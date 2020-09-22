package com.echuang.modules.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 9:33
 * @Version 1.0
 */
@TableName("cms_notice")
public class CmsNoticeEntity implements Serializable{
    @TableId(value = "notice_id",type = IdType.INPUT)
    private Long noticeId;

    @NotBlank(message = "通知标题不能为空")
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
     * 显示顺序
     */
    private Integer priority;
    /**
     * 发布时间
     */
    private Date publicTime;

    public CmsNoticeEntity() { }

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

    public Integer getPriority() { return priority; }

    public void setPriority(Integer priority) { this.priority = priority; }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }
}
