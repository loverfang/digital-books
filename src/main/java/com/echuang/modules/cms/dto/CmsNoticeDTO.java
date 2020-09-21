package com.echuang.modules.cms.dto;

import java.io.Serializable;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 17:15
 * @Version 1.0
 */
public class CmsNoticeDTO implements Serializable {
    private Long noticeId;

    private String title;

    /**
     * 通知内容
     */
    private String content;
    /**
     * 来源
     */
    private String source;
    /**
     * 发布者
     */
    private String author;
    /**
     * 发布时间
     */
    private String publicTime;

    public CmsNoticeDTO() { }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
    }
}
