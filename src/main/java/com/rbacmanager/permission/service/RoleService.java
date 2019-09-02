package com.rbacmanager.permission.service;

import com.rbacmanager.permission.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> listRoles();

    Role selectByPrimaryKey(Integer id);

    void deleteByPrimaryKey(Integer id);

    String selectRoleNameByRoleId(Integer id);
}
