package com.rbacmanager.permission.mapper;

import com.rbacmanager.permission.pojo.RealUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RealUserMapper {
    RealUser selectByUserName(String username);
}
