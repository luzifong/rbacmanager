package com.rbacmanager.permission.mapper;

import com.rbacmanager.permission.pojo.Permission;
import com.rbacmanager.permission.pojo.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<Permission> listPermissions();

    String selectPermissionNameByPermissionId(Integer id);

    void addRolePermission(RolePermission rolePermission);

    void deleteByPrimaryKey(Integer id);
}
