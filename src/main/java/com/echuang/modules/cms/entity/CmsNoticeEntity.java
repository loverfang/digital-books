package com.echuang.modules.cms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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
     * 发布时间
     */
    private String publicTime;

}
