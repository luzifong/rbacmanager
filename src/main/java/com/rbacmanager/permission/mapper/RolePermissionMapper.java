package com.rbacmanager.permission.mapper;

import com.rbacmanager.permission.pojo.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RolePermissionMapper {
    List<Map<String, Object>> selectRolePermissionByRolePrimaryKey(Integer id);

    void addRolePermission(RolePermission rolePermission);

    void deleteRolePermissionByRolePrimaryKey(Integer id);

    void deleteRolePermissionByPermissionPrimaryKey(Integer id);
}
