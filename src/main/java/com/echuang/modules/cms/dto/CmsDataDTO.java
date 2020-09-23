package com.echuang.modules.cms.dto;

import com.echuang.modules.cms.entity.CmsDataFileEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 16:44
 * @Version 1.0
 */
public class CmsDataDTO implements Serializable {
    private Long dataId;
    /**
     * 资料类别Id
     */
    private Long categoryId;
    /**
     * 资料父类别Id
     */
    private Long parentId;
    /**
     * 资料名称
     */
    private String name;
    /**
     * 资料摘要
     */
    private String abstracts;
    /**
     * 资料内容
     */
    private String content;
    /**
     * 资料封面图片
     */
    private String coverImgUrl;
    /**
     * 资料作者
     */
    private String author;
    /**
     * 发表平台
     */
    private String platform;
    /**
     * 资料来源
     */
    private String source;
    /**
     * 资料编号
     */
    private String publicNum;
    /**
     * 查看次数
     */
    private Integer viewCount;
    /**
     * 下载次数
     */
    private Integer downCount;
    /**
     * 资料状态:1正常,0下架，默认1
     */
    private Integer status;
    /**
     * 资料上传时间
     */
    private Date createTime;
    /**
     * 资料类别名称
     */
    private String categoryName;

    private List<CmsDataFileEntity> dataFileList;

    public CmsDataDTO() { }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublicNum() {
        return publicNum;
    }

    public void setPublicNum(String publicNum) {
        this.publicNum = publicNum;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<CmsDataFileEntity> getDataFileList() {
        return dataFileList;
    }

    public void setDataFileList(List<CmsDataFileEntity> dataFileList) {
        this.dataFileList = dataFileList;
    }
}
