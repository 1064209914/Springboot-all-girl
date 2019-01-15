package com.hxd.shiro.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hxd.shiro.entry.User;

@Mapper
public interface UserMapper {

   public User findByUsername(String username);
}
