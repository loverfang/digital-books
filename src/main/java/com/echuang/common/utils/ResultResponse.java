package com.echuang.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/8/26 12:34
 * @Version 1.0
 */
public class ResultResponse extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultResponse() {
        put("code", 200);
        put("msg", "success");
    }

    public static ResultResponse error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static ResultResponse error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static ResultResponse error(int code, String msg) {
        ResultResponse r = new ResultResponse();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultResponse ok(String msg) {
        ResultResponse r = new ResultResponse();
        r.put("msg", msg);
        return r;
    }

    public static ResultResponse ok(Map<String, Object> map) {
        ResultResponse r = new ResultResponse();
        r.putAll(map);
        return r;
    }

    public static ResultResponse ok() {
        return new ResultResponse();
    }

    public ResultResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public ResultResponse put(Object value) {
        super.put("data", value);
        return this;
    }
}
