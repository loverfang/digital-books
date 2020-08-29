package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.DateUtils;
import com.echuang.common.utils.PageUtils;
import com.echuang.common.utils.Query;
import com.echuang.common.utils.SnowflakeIdWorker;
import com.echuang.modules.cms.entity.CmsDataEntity;
import com.echuang.modules.cms.entity.CmsDataFileEntity;
import com.echuang.modules.cms.mapper.CmsDataFileMapper;
import com.echuang.modules.cms.mapper.CmsDataMapper;
import com.echuang.modules.cms.service.CmsDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/8/29 10:16
 * @Version 1.0
 */
@Service("cmsDataService")
public class CmsDataServiceImpl extends ServiceImpl<CmsDataMapper, CmsDataEntity> implements CmsDataService{

    @Resource
    private CmsDataMapper cmsDataMapper;
    @Resource
    CmsDataFileMapper cmsDataFileMapper;

    @Override
    public PageUtils queryPageList(Map<String,Object> queryMap) {
        // 新建分页
        //Page<Map<String,Object>> page = new Page<Map<String,Object>>(pageNo,limit);
        IPage<CmsDataEntity> page= new Query<CmsDataEntity>().getPage(queryMap);
        // 返回结果
        return  new PageUtils(page.setRecords(cmsDataMapper.queryPageList(page,queryMap)));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveCmsData(CmsDataEntity cmsDataEntity) {
        Long dataId = SnowflakeIdWorker.getSnowflakeId();
        cmsDataEntity.setViewCount(0);
        cmsDataEntity.setDownCount(0);
        cmsDataEntity.setStatus(1);
        cmsDataEntity.setCreateTime(new Date());
        cmsDataEntity.setDataId( dataId );
        cmsDataMapper.insert(cmsDataEntity);

        Long dataFileId = SnowflakeIdWorker.getSnowflakeId();
        CmsDataFileEntity dataFileEntity = cmsDataEntity.getCmsDataFile();
        if(dataFileEntity == null){
           dataFileEntity  = new CmsDataFileEntity();
        }

        dataFileEntity.setFileId(dataFileId);
        dataFileEntity.setFileId(dataId);
        cmsDataFileMapper.insert(dataFileEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateCmsData(CmsDataEntity cmsDataEntity) {
        cmsDataMapper.updateById(cmsDataEntity);
        cmsDataFileMapper.updateById(cmsDataEntity.getCmsDataFile());
    }

    @Override
    public CmsDataEntity getCmsDataById(Long id) {
        CmsDataEntity cmsDataEntity = cmsDataMapper.getCmsDataById(id);
        return cmsDataEntity;
    }

    @Override
    public void updateStatusBatchByMap(Map<String, Object> param) {
        cmsDataMapper.updateStatusBatchByMap(param);
    }

}
