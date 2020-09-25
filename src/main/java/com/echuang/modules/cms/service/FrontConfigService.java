package com.echuang.modules.cms.service;

public interface FrontConfigService {

    String getValue(String key);

    /**
     * 根据key，获取value的Object对象
     * @param key    key
     * @param clazz  Object对象
     */
     <T> T getConfigObject(String key, Class<T> clazz);
}
