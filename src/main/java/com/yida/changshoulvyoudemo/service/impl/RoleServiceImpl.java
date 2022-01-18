package com.yida.changshoulvyoudemo.service.impl;

import com.yida.changshoulvyoudemo.entity.Role;
import com.yida.changshoulvyoudemo.exception.R;
import com.yida.changshoulvyoudemo.mapper.RoleDao;
import com.yida.changshoulvyoudemo.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Role)表服务实现类
 *
 * @author xixidigua
 * @since 2022-01-03 15:00:54
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;
    @Override
    public Role queryByRoleId(Integer roleId) {
        return roleDao.queryByRoleId(roleId);
    }




}
