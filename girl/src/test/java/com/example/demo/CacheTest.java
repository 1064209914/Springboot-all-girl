package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.conctroller.HellowWorldController;
import com.example.demo.entity.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

	@Autowired
	private HellowWorldController hellowWorldController;

	@Autowired
 	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void testGetOne() throws Exception {
		UserEntity users = hellowWorldController.getUser(1123456);
		System.out.println(users.toString());
	}
	@Test
	public void getValue() throws Exception {
		String users = stringRedisTemplate.opsForValue().get("user::1");
		System.out.println(users.toString());
		
		
	}

	
}
