package com.rbacmanager.permission.service.impl;

import com.rbacmanager.permission.mapper.UserMapper;
import com.rbacmanager.permission.pojo.User;
import com.rbacmanager.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public void deleteByPrimaryKey(Integer id) {
        deleteUserRoleByUserPrimaryKey(id);
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteUserRoleByUserPrimaryKey(Integer id) {
        userMapper.deleteUserRoleByUserPrimaryKey(id);
    }

    @Override
    public List<Map<String, Object>> selectUserRole(Integer id) {
        return userMapper.selectUserRole(id);
    }

    @Override
    public String selectUsernameByUserId(Integer id) {
        return userMapper.selectUsernameByUserId(id);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTokenInfoByUserId(Integer user_id, String token, Date date) {
        userMapper.updateTokenInfoByUserId(user_id, token, date);
    }

    @Override
    public void cleanTokenInfoByUserId(Integer user_id, Date date) {
        userMapper.cleanTokenInfoByUserId(user_id, date);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User selectByUid(Integer uid) {
        return userMapper.selectByUid(uid);
    }

    @Override
    public void updateAvailability(Integer user_id) {
        userMapper.updateAvailability(user_id);
    }
}
