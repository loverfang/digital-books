package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.Query;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.mapper.CmsCategoryMapper;
import com.echuang.modules.cms.service.CmsCategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service("cmsCategoryService")
public class CmsCategoryServiceImpl extends ServiceImpl<CmsCategoryMapper, CmsCategoryEntity> implements CmsCategoryService {

    @Resource
    private CmsCategoryMapper cmsCategoryMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String categoryName = (String)params.get("categoryName");
        Long parentId = Long.parseLong((String)params.get("parentId"));
        IPage<CmsCategoryEntity> page = this.page(
                new Query<CmsCategoryEntity>().getPage(params),
                new QueryWrapper<CmsCategoryEntity>()
                        .like(StringUtils.isNotBlank(categoryName), "category_name", categoryName)
                        .eq("parent_id", parentId)
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByParent(Map<String,Object> params, Integer pageNo, Integer limit) {
        // 新建分页
        Page<Map<String,Object>> page = new Page<Map<String,Object>>(pageNo,limit);
        params.put("status", 1);
        // 返回结果
        return  new PageUtils(page.setRecords(cmsCategoryMapper.queryPageList(page,  params)));
    }

    @Override
    public List<Map<String, Object>> childList(Long parentId) {
        return cmsCategoryMapper.childList(parentId);
    }

    @Override
    public List<CmsCategoryEntity> treeList() {
        return this.baseMapper.selectList(null);
    }

    @Override
    public CmsCategoryEntity detail(Long categoryId) {
        return this.baseMapper.selectById( categoryId );
    }

    @Override
    public int add(CmsCategoryEntity cmsCategoryEntity) {
        return this.baseMapper.insert(cmsCategoryEntity);
    }

    @Override
    public int update(CmsCategoryEntity cmsCategoryEntity) {
        return this.baseMapper.updateById(cmsCategoryEntity);
    }

    @Override
    public int batchUpdateStatus(List<Long> bannerIds, Integer status) {
        // has have child
        this.baseMapper.childList(bannerIds.get(0));

        // heck
        return 0;
    }

    @Override
    public int updateStatus(Long categoryId, Integer status){
        List<Map<String,Object>> childList = cmsCategoryMapper.childList(categoryId);
        if(CollectionUtils.isNotEmpty(childList) && childList.size()>0) {
            return 0;
        }else{
            CmsCategoryEntity categoryEntity = new CmsCategoryEntity();
            categoryEntity.setCategoryId(categoryId);
            categoryEntity.setStatus(status);

            //修改条件s
            UpdateWrapper<CmsCategoryEntity> userUpdateWrapper = new UpdateWrapper<>();
            userUpdateWrapper.eq("category_id", categoryId);

            return cmsCategoryMapper.update(categoryEntity, userUpdateWrapper);
        }
    }
}
