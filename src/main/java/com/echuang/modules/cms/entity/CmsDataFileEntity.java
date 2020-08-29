package com.echuang.modules.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 9:40
 * @Version 1.0
 */
@TableName("cms_data_file")
public class CmsDataFileEntity implements Serializable {
    @TableId(value="file_id", type = IdType.INPUT)
    private Long fileId;
    /**
     * 资料ID
     */
    @NotBlank(message = "所属资料不能为空")
    private Long dataId;
    /**
     * 文件名称
     */
    @NotBlank(message = "文件名称不能为空")
    private String fileName;
    /**
     * 文件大小单位B
     */
    private Long fileSize;
    /**
     * 文件路径
     */
    @NotBlank(message = "文件路径不能为空")
    private String filePath;
    /**
     * 文件类型
     */
    private String fileType;

    public CmsDataFileEntity() {
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
