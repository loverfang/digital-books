package com.echuang.modules.cms.dto;

import java.io.Serializable;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 16:34
 * @Version 1.0
 */
public class CmsCategoryDTO implements Serializable {
    private Long categoryId;
    private String categoryName;
    private String categoryUrl;

    public CmsCategoryDTO() { }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

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
}
