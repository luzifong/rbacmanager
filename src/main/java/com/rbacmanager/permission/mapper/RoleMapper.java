package com.rbacmanager.permission.mapper;

import com.rbacmanager.permission.pojo.Role;
import com.rbacmanager.permission.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {
    List<Role> listRoles();

    Role selectByPrimaryKey(Integer id);

    void deleteByPrimaryKey(Integer id);

    void deleteUserRoleByRolePrimaryKey(Integer id);

    void deleteRolePermissionByRolePrimaryKey(Integer id);

    List<Map<String, Object>> selectRolePermission(Integer id);

    String selectRoleNameByRoleId(Integer id);

    void addUserRole(UserRole userRole);
}
