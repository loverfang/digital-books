package com.echuang.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * @Author Luo.z.x
 * @Date 2020/8/26 12:34
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
