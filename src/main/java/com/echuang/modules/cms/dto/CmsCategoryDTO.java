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
    private List<CmsCategoryDTO> childList;

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

    public void setChildList(List<CmsCategoryDTO> childList) {
        this.childList = childList;
    }
}
