package com.rbacmanager.permission.mapper;

import com.rbacmanager.permission.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<User> listUser();

    User selectByPrimaryKey(Integer id);

    User selectByUid(Integer uid);

    void deleteByPrimaryKey(Integer id);

    String selectUsernameByUserId(Integer id);

    void updateTokenInfoByUserId(Integer user_id, String token, Date date);

    void updateAvailability(Integer user_id);

    void cleanTokenInfoByUserId(Integer user_id, Date date);

    void addUser(User user);
}
