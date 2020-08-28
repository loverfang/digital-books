package com.echuang.modules.oss.controller;

import com.echuang.common.exception.RRException;
import com.echuang.common.utils.ResultResponse;
import com.echuang.modules.oss.service.OssService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
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

    @Resource
    private OssService ossService;

    /**
     * 上传文件
     */
    @PostMapping("/uploadFile")
    public ResultResponse upload(@RequestParam("file") MultipartFile file) throws Exception {
        MultipartFile[] files = new MultipartFile[1];
        files[0] = file;
        List<Map<String,Object>> uploadResultMap =  ossService.uploadFile(files);
        return ResultResponse.ok().put("files", uploadResultMap);
    }

    /**
     * 批量上传文件
     * @param files
     * @return
     */
    @PostMapping("/uploadFiles")
    public ResultResponse upload(@RequestParam("file") MultipartFile[] files) throws Exception {
        List<Map<String,Object>> uploadResultListMap =  ossService.uploadFile(files);
        return ResultResponse.ok().put("files", uploadResultListMap);
    }

}
