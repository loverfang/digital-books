package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.Query;
import com.echuang.modules.cms.dto.CmsCategoryDTO;
import com.echuang.modules.cms.entity.CmsCategoryEntity;
import com.echuang.modules.cms.mapper.CmsCategoryMapper;
import com.echuang.modules.cms.service.CmsCategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.*;

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
                        .eq("parent_id", parentId).eq("status", 1)
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
        return this.baseMapper.selectList(new UpdateWrapper<CmsCategoryEntity>().eq("status", 1));
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
        CmsCategoryEntity categoryEntity = cmsCategoryMapper.selectById(categoryId);
        if(categoryEntity!=null){
            Integer isDefault = categoryEntity.getIsDefault();
            if(isDefault == 1){
                return -1;
            }
        }

        List<Map<String,Object>> childList = cmsCategoryMapper.childList(categoryId);
        if(CollectionUtils.isNotEmpty(childList) && childList.size()>0) {
            return 0;
        }else{
            CmsCategoryEntity updateCategoryEntity = new CmsCategoryEntity();
            updateCategoryEntity.setCategoryId(categoryId);
            updateCategoryEntity.setStatus(status);

            //修改条件s
            UpdateWrapper<CmsCategoryEntity> userUpdateWrapper = new UpdateWrapper<>();
            userUpdateWrapper.eq("category_id", categoryId);

            return cmsCategoryMapper.update(updateCategoryEntity, userUpdateWrapper);
        }
    }

    @Override
    public List<CmsCategoryDTO> webChannels(Long parentId) {

        List<Map<String, Object>> webMainChannels = cmsCategoryMapper.frontChildList(parentId);
        List<CmsCategoryDTO> navgaterList = new ArrayList<>();
        if( webMainChannels!=null && webMainChannels.size()>0 ){
            for(Map<String, Object> channel:webMainChannels){
                System.out.println( "---------------->" + channel.get("categoryName"));
                CmsCategoryDTO tempDTO = new CmsCategoryDTO();
                tempDTO.setCategoryId((Long)channel.get("categoryId"));
                tempDTO.setParentId((Long)channel.get("parentId"));
                tempDTO.setCategoryName((String)channel.get("categoryName"));

                // 如果有子菜单
                if(secondLevelChannels( tempDTO.getCategoryId() ).size()<=0){
                    if(channel.get("categoryUrl")!=null && !"".equals((String)channel.get("categoryUrl"))){
                        tempDTO.setCategoryUrl((String)channel.get("categoryUrl"));
                    } else {
                        tempDTO.setCategoryUrl("/product/list/"+tempDTO.getParentId()+"/"+tempDTO.getCategoryId() + ".html");
                    }
                }else {
                    //tempDTO.setCategoryUrl("");
                }

                tempDTO.setChildList( secondLevelChannels( tempDTO.getCategoryId() ));
                navgaterList.add(tempDTO);
            }
        }

        return navgaterList;
    }

    //二级栏目查询
    private  List<CmsCategoryDTO> secondLevelChannels(Long parentId){
        List<Map<String, Object>> secondChannels = cmsCategoryMapper.childList(parentId);
        List<CmsCategoryDTO> navgaterList = new ArrayList<>();
        if( secondChannels!=null && secondChannels.size()>0 ){
            for(Map<String, Object> channel:secondChannels){
                CmsCategoryDTO tempDTO = new CmsCategoryDTO();
                tempDTO.setCategoryId((Long)channel.get("categoryId"));
                tempDTO.setParentId((Long)channel.get("parentId"));
                tempDTO.setCategoryName((String)channel.get("categoryName"));

                // 如果有子菜单
                if(secondLevelChannels( tempDTO.getCategoryId() ).size()<=0){
                    if(channel.get("categoryUrl")!=null && !"".equals((String)channel.get("categoryUrl"))){
                        tempDTO.setCategoryUrl((String)channel.get("categoryUrl"));
                    } else {
                        tempDTO.setCategoryUrl("/product/list/"+tempDTO.getParentId()+"/"+tempDTO.getCategoryId() + ".html");
                    }
                }else {
                    tempDTO.setCategoryUrl("/product/list/"+tempDTO.getParentId()+"/"+tempDTO.getCategoryId() + ".html");
                    //tempDTO.setCategoryUrl("");
                }

                tempDTO.setChildList( thirdLevelChannels( tempDTO.getCategoryId() ));
                navgaterList.add(tempDTO);
            }
        }

        return navgaterList;
    }

    //三级栏目查询
    private  List<CmsCategoryDTO> thirdLevelChannels(Long parentId) {
        List<Map<String, Object>> webThirdChannels = cmsCategoryMapper.childList(parentId);
        List<CmsCategoryDTO> navgaterList = new ArrayList<>();
        if( webThirdChannels!=null && webThirdChannels.size()>0 ){
            for(Map<String, Object> channel:webThirdChannels){
                CmsCategoryDTO tempDTO = new CmsCategoryDTO();
                tempDTO.setCategoryId((Long)channel.get("categoryId"));
                tempDTO.setParentId((Long)channel.get("parentId"));
                tempDTO.setCategoryName((String)channel.get("categoryName"));

                if(channel.get("categoryUrl")!=null && !"".equals((String)channel.get("categoryUrl"))){
                    tempDTO.setCategoryUrl((String)channel.get("categoryUrl"));
                } else {
                    tempDTO.setCategoryUrl("/product/list/"+tempDTO.getParentId()+"/"+tempDTO.getCategoryId() + ".html");
                }

                navgaterList.add(tempDTO);
            }
        }
        return navgaterList;
    }
}
