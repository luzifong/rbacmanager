package com.rbacmanager.permission.service.impl;

import com.rbacmanager.permission.mapper.RoleMapper;
import com.rbacmanager.permission.mapper.RolePermissionMapper;
import com.rbacmanager.permission.mapper.UserRoleMapper;
import com.rbacmanager.permission.pojo.Role;
import com.rbacmanager.permission.pojo.UserRole;
import com.rbacmanager.permission.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public List<Role> listRoles() {
        return roleMapper.listRoles();
    }

    @Override
    public String selectRoleNameByRoleId(Integer id) {
        return roleMapper.selectRoleNameByRoleId(id);
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        userRoleMapper.deleteUserRoleByRolePrimaryKey(id);
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
