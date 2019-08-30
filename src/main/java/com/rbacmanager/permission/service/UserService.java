package com.rbacmanager.permission.service;

import com.rbacmanager.permission.pojo.User;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> listUser();

    User selectByPrimaryKey(Integer id);

    User selectByUid(Integer uid);

    void deleteByPrimaryKey(Integer id);

    void deleteUserRoleByUserPrimaryKey(Integer id);

    List<Map<String, Object>> selectUserRole(Integer id);

    String selectUsernameByUserId(Integer id);

    void updateTokenInfoByUserId(Integer user_id, String token, Date date);

    void updateAvailability(Integer user_id);

    void cleanTokenInfoByUserId(Integer user_id, Date date);

    void addUser(User user);
}
