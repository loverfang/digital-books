package com.echuang.modules.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import java.util.List;
import java.util.Map;

public interface CmsCategoryService extends IService<CmsCategoryEntity> {

    /**
     * 分页查询模型列表:分页参数为page(当前页码),limit(每页条数)
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 指定查询分页列表
     * @param params
     * @param page
     * @param limit
     * @return
     */
    PageUtils queryPageByParent(Map<String, Object> params, Integer page, Integer limit);

    /**
     * 根据id查询其子类别
     * @param parentId
     * @return
     */
    List<Map<String, Object>> childList(Long parentId);

    /**
     * 添加模型
     * @param cmsCategoryEntity
     * @return
     */
    int add(CmsCategoryEntity cmsCategoryEntity);

    /**
     * 更新模型
     * @param cmsCategoryEntity
     * @return
     */
    int update(CmsCategoryEntity cmsCategoryEntity);

    /**
     * 批量删除类型    * @param categroyIds
     * @return
     */
    int batchUpdateStatus(List<Long> categroyIds, Integer status);

    /**
     * 删除类型
     * @param categoryId
     * @return
     */
    int updateStatus(Long categoryId, Integer status);

    /**
     * 类别详情
     * @param categoryId
     * @return
     */
    CmsCategoryEntity detail(Long categoryId);

    /**
     * 查询所有分类
     * @return
     */
    List<CmsCategoryEntity> treeList();


}
