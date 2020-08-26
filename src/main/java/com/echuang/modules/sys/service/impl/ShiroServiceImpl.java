package com.echuang.modules.sys.service.impl;

import com.echuang.common.utils.Constant;
import com.echuang.modules.sys.entity.SysMenuEntity;
import com.echuang.modules.sys.entity.SysUserEntity;
import com.echuang.modules.sys.entity.SysUserTokenEntity;
import com.echuang.modules.sys.mapper.SysMenuMapper;
import com.echuang.modules.sys.mapper.SysUserMapper;
import com.echuang.modules.sys.mapper.SysUserTokenMapper;
import com.echuang.modules.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserTokenMapper sysUserTokenMapper;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            List<SysMenuEntity> menuList = sysMenuMapper.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for (SysMenuEntity menu : menuList) {
                permsList.add(menu.getPerms());
            }
        } else {
            permsList = sysUserMapper.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenMapper.queryByToken(token);
    }

    @Override
    public SysUserEntity queryUser(Long userId) {
        return sysUserMapper.selectById(userId);
    }
}
