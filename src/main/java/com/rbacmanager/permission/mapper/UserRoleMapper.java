package com.rbacmanager.permission.mapper;

import com.rbacmanager.permission.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserRoleMapper {
    void deleteUserRoleByUserPrimaryKey(Integer id);

    void deleteUserRoleByRolePrimaryKey(Integer id);

    List<Map<String, Object>> selectUserRoleByUserPrimaryKey(Integer id);

    void addUserRole(UserRole userRole);
}
