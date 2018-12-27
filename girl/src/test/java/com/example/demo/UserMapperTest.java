package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		/*UserMapper.insert(new UserEntity("aa", "a123456",1));
		UserMapper.insert(new UserEntity("bb", "b123456", 2));
		UserMapper.insert(new UserEntity("cc", "b123456", 1));*/
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		System.out.println(users.toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(1);
		System.out.println(user.toString());
		user.setUserName("小明");
		UserMapper.update(user);
		System.out.println("aa".equals(UserMapper.getOne(1).getUserName()));
	}
}
