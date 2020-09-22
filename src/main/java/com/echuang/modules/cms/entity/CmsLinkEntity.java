package com.echuang.modules.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 8:59
 * @Version 1.0
 */
@TableName("cms_link")
public class CmsLinkEntity implements Serializable {
    @TableId(value="link_id", type= IdType.INPUT)
    @NotBlank( message = "链接ID不能为空")
    private Long linkId;
    @NotBlank( message = "链接名称不能为空")
    private String name;
    @NotBlank( message = "链接地址不能为空")
    private String url;
    private Integer priority;
    private Integer status;
    private String remark;

    public CmsLinkEntity() {  }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
