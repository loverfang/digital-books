package com.echuang.modules.oss.controller;

import com.echuang.common.exception.RRException;
import com.echuang.common.utils.ResultResponse;
import com.echuang.modules.oss.service.OssService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * @Author Luo.z.x
 * @Date 2020/8/28 11:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/oss")
public class OssController {

    private final static Logger logger = LoggerFactory.getLogger(OssController.class);

    @Autowired
    private OssService ossService;

    /**
     * 上传文件
     */
    @PostMapping("/uploadFile")
    @RequiresPermissions("sys:oss:upload")
    public ResultResponse upload(@RequestParam(name = "file") MultipartFile file, @RequestParam(name = "childPath",required = false) String childPath) throws Exception {
        MultipartFile[] files = new MultipartFile[1];
        files[0] = file;
        List<Map<String,Object>> uploadResultMap =  ossService.uploadFile(files, childPath);
        return ResultResponse.ok().put("files", uploadResultMap);
    }

    /**
     * 批量上传文件
     * @param files
     * @return
     */
    @PostMapping("/uploadFiles")
    @RequiresPermissions("sys:oss:upload")
    public ResultResponse upload(@RequestParam(name = "file") MultipartFile[] files, @RequestParam(name = "childPath",required = false) String childPath)throws Exception {
        List<Map<String,Object>> uploadResultListMap =  ossService.uploadFile(files, childPath);
        return ResultResponse.ok().put("files", uploadResultListMap);
    }

    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> download(@RequestParam String fileName, HttpServletRequest request) throws UnsupportedEncodingException {
        // Load file as Resource
        Resource resource = ossService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            // 下载文件能正常显示中文
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode(resource.getFilename(),"UTF-8") + "\"")
            .body(resource);
    }
}
