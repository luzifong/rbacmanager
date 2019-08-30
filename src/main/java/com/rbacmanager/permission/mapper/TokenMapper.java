package com.rbacmanager.permission.mapper;

import com.rbacmanager.permission.pojo.UserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenMapper {
    UserToken selectByPrimaryKey(Integer uid);

    void addUserToken(UserToken userToken);

    void updateUserToken(String token);
}
