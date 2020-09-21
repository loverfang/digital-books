package com.echuang.modules.cms.dto;

import java.io.Serializable;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 17:58
 * @Version 1.0
 */
public class CmsLinkDTO implements Serializable {
    private Long linkId;
    private String name;
    private String url;
    private Integer status;
    private String remark;

    public CmsLinkDTO() { }
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
