package com.rbacmanager.permission.service;

import com.rbacmanager.permission.pojo.Permission;
import com.rbacmanager.permission.pojo.RolePermission;

import java.util.List;

public interface PermissionService {
    List<Permission> listPermissions();

    String selectPermissionNameByPermissionId(Integer id);

    void addRolePermission(RolePermission rolePermission);

    void deleteByPrimaryKey(Integer id);

    void deleteRolePermissionByPermissionPrimaryKey(Integer id);
}
