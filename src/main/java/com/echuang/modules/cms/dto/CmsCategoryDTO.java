package com.echuang.modules.cms.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 16:34
 * @Version 1.0
 */
public class CmsCategoryDTO implements Serializable {
    private Long categoryId;
    private Long parentId;
    private String categoryName;
    private String categoryUrl;
    private String coverUrl;
    /** 子类别列表  **/
    private List<CmsCategoryDTO> childList;
    /** 类属新闻列表  **/
    private List<CmsDataDTO> dataList;

    public CmsCategoryDTO(Long categoryId, Long parentId, String categoryName) {
        this.categoryId = categoryId;
        this.parentId = parentId;
        this.categoryName = categoryName;
    }

    public CmsCategoryDTO() { }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getParentId() { return parentId; }

    public void setParentId(Long parentId) { this.parentId = parentId; }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public List<CmsCategoryDTO> getChildList() {
        return childList;
    }

    public String getCoverUrl() { return coverUrl;  }

    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }

    public void setChildList(List<CmsCategoryDTO> childList) { this.childList = childList;  }

    public List<CmsDataDTO> getDataList() {  return dataList;  }

    public void setDataList(List<CmsDataDTO> dataList) { this.dataList = dataList; }
}
