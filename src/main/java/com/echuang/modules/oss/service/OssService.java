package com.echuang.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.echuang.common.exception.RRException;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.oss.entity.OssEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * @Author Luo.z.x
 * @Date 2020/8/28 15:21
 * @Version 1.0
 */
public interface OssService extends IService<OssEntity> {
    PageUtils queryPage(Map<String, Object> params);
    List<Map<String,Object>> uploadFile(MultipartFile[] files,String childPath) throws RRException;
    Resource loadFileAsResource(String fileName);
}
