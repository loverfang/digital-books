package com.echuang.modules.oss.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.exception.RRException;
import com.echuang.common.utils.DateUtils;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.oss.OSSConst;
import com.echuang.modules.oss.entity.OssEntity;
import com.echuang.modules.oss.mapper.OssEntityMapper;
import com.echuang.modules.oss.service.OssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @Author Luo.z.x
 * @Date 2020/8/28 15:26
 * @Version 1.0
 */
@Service
public class OssServiceImpl extends ServiceImpl<OssEntityMapper, OssEntity> implements OssService {
    private static Logger logger = LoggerFactory.getLogger(OssServiceImpl.class);
    /**
     * 请求 url 中的资源映射，不推荐写死在代码中，最好提供可配置，如 /upload_/**
     */
    @Value("${uploadFile.resourceHandler}")
    private String resourceHandler;

    /**
     * 上传文件保存的本地目录，使用@Value获取全局配置文件中配置的属性值，如 D:/webdata/
     */
    @Value("${uploadFile.location}")
    private String uploadLocation;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public  List<Map<String,Object>> uploadFile(MultipartFile[] files, String childPath) throws RRException {
        StringBuffer filesPath = new StringBuffer();
        List<Map<String,Object>> filesResult = new ArrayList<Map<String,Object>>();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                // 上传文件为空
                throw new RRException("上传图片不能为空");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            String contentType = file.getContentType();
            if (!OSSConst.UPLOAD_FILES_TYPES.contains(contentType)) {
                // 抛出文件类型不符合规定
                throw new RRException("文件类型不符合");
            }
            map.put("fileType", contentType);

            long fileSize = file.getSize();
            if (fileSize > OSSConst.UPLOAD_FILES_MAX_SIZE) {
                // 上传文件超出大小限制
                throw new RRException("上传文件大小超限");
            }
            map.put("fileSize", fileSize);

            File parent = new File(uploadLocation);
            if (!parent.exists()) {
                parent.mkdirs();
            }

            String child = file.getOriginalFilename();
            // 确定上传的文件的扩展名
            String suffix = "";
            int beginIndex = child.lastIndexOf(".");
            if (beginIndex != -1) {
                suffix = child.substring(beginIndex);
            }

            // 获取原文件名称（不包含文件扩展名）
            String prefix = child.substring(0, beginIndex);
            logger.info("文件后缀:{}", prefix);

            // 设置文件保存名称
            child = prefix + DateUtils.format(new Date(),"yyyyMMddHHmmss") + suffix;
            map.put("fileName", child);

            File dest = new File(uploadLocation, child);
            try {
                // 执行保存
                file.transferTo(dest);
                logger.info("文件上传路径:{}", dest.getPath());
            } catch (IllegalStateException e) {
                e.printStackTrace();
                // 上传失败，所选择的文件已经不可用
                throw new RRException("所上传的文件不可用");
            } catch (IOException e) {
                e.printStackTrace();
                // 上传失败，读写数据时出现错误
                throw new RRException("上传失败，重新上传");
            }

            // 相对父级路径
            String relativePath = resourceHandler.substring(0, resourceHandler.lastIndexOf("/") + 1);
            logger.info("父级路径：{}", relativePath);

            if (filesPath.length() == 0) {
                filesPath.append(relativePath + child);
            } else {
                filesPath.append(filesPath + relativePath + child);
            }
            map.put("filePath", filesPath.toString());
            filesResult.add( map );
        }

        return filesResult;
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path fileStorageLocation = Paths.get(uploadLocation) .toAbsolutePath().normalize();
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new RRException("File not found " + fileName);
            }
        } catch (RRException | MalformedURLException ex) {
            throw new RRException("File not found " + fileName, ex);
        }
    }
}
