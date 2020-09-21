package com.echuang.modules.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@TableName("cms_category")
public class CmsCategoryEntity  implements Serializable {

    @TableId(value="category_id", type= IdType.INPUT)
    private Long categoryId;

    @NotBlank(message = "类型名称不能为空")
    private String categoryName;

    private String categoryUrl;

    @NotBlank(message = "父类ID不能为空")
    private String parentId;

    @NotBlank(message = "显示顺序不能为空")
    private Integer priority;

    @NotBlank(message = "型状态")
    private Integer status;
    @NotBlank(message = "是否为系统菜单")
    private Integer isDefault;

    private String remark;

    @TableField(exist = false)
    private String parentName;

    @TableField(exist = false)
    private List<CmsCategoryEntity> children = new ArrayList<>();

    public CmsCategoryEntity() { }

    public CmsCategoryEntity(Long categoryId, @NotBlank(message = "类型名称不能为空") String categoryName, @NotBlank(message = "父类ID不能为空") String parentId, @NotBlank(message = "显示顺序不能为空") Integer priority, String remark) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentId = parentId;
        this.priority = priority;
        this.remark = remark;
    }

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

    public String getCategoryUrl() { return categoryUrl; }

    public void setCategoryUrl(String categoryUrl) { this.categoryUrl = categoryUrl; }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public Integer getIsDefault() { return isDefault; }

    public void setIsDefault(Integer isDefault) { this.isDefault = isDefault; }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<CmsCategoryEntity> getChildren() {
        return children;
    }

    public void setChildren(List<CmsCategoryEntity> children) {
        this.children = children;
    }
}
