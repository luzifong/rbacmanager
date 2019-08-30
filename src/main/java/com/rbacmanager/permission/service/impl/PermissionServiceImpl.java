package com.rbacmanager.permission.service.impl;

import com.rbacmanager.permission.mapper.PermissionMapper;
import com.rbacmanager.permission.pojo.Permission;
import com.rbacmanager.permission.pojo.RolePermission;
import com.rbacmanager.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public String selectPermissionNameByPermissionId(Integer id) {
        return permissionMapper.selectPermissionNameByPermissionId(id);
    }

    @Override
    public void addRolePermission(RolePermission rolePermission) {
        permissionMapper.addRolePermission(rolePermission);
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        deleteRolePermissionByPermissionPrimaryKey(id);
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Permission> listPermissions() {
        return permissionMapper.listPermissions();
    }

    @Override
    public void deleteRolePermissionByPermissionPrimaryKey(Integer id) {
        permissionMapper.deleteRolePermissionByPermissionPrimaryKey(id);
    }
}
