package com.rbacmanager.permission.service;

import com.rbacmanager.permission.pojo.Role;
import com.rbacmanager.permission.pojo.UserRole;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Role> listRoles();

    Role selectByPrimaryKey(Integer id);

    void deleteByPrimaryKey(Integer id);

    void deleteUserRoleByRolePrimaryKey(Integer id);

    void deleteRolePermissionByRolePrimaryKey(Integer id);

    List<Map<String, Object>> selectRolePermission(Integer id);

    String selectRoleNameByRoleId(Integer id);

    void addUserRole(UserRole userRole);
}
