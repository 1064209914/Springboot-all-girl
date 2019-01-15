package com.hxd.shiro.serviceipl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxd.shiro.entry.User;
import com.hxd.shiro.mapper.UserMapper;
import com.hxd.shiro.service.UserService;

@Service
public class UserServiceipl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByUsername(String username) {

		return userMapper.findByUsername(username);
	}

}
