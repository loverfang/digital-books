package com.echuang.modules.cms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.echuang.common.utils.PageUtils;
import com.echuang.modules.cms.dto.CmsNoticeDTO;
import com.echuang.modules.cms.entity.CmsNoticeEntity;
import com.echuang.modules.cms.mapper.CmsNoticeMapper;
import com.echuang.modules.cms.service.FrontNoticeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Luo.z.x
 * @Date 2020/9/21 17:21
 * @Version 1.0
 */
@Service
public class FrontNoticeServiceImpl extends ServiceImpl<CmsNoticeMapper, CmsNoticeEntity> implements FrontNoticeService {

    @Resource
    CmsNoticeMapper cmsNoticeMapper;

    @Override
    public PageUtils noticeList(Integer pageNo, Integer pageSize) {
        // 新建分页
        Page<Map<String,Object>> page = new Page<Map<String,Object>>(pageNo, pageSize);

        List<Map<String,Object>> resultList = cmsNoticeMapper.queryPageList(page, null);
        return  new PageUtils(page.setRecords(resultList));
    }

    @Override
    public CmsNoticeDTO noticeDetail(Long id) {
        CmsNoticeEntity cmsNoticeEntity = cmsNoticeMapper.selectById(id);
        CmsNoticeDTO resultDTO = new CmsNoticeDTO();
        if(cmsNoticeEntity!=null) {
            BeanUtils.copyProperties(cmsNoticeEntity, resultDTO);
            return resultDTO;
        }
        return resultDTO;
    }


}
