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
    private Integer status;
    private String remark;
}
