package com.example.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.config.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfigApplicationTests {

	@Autowired
	private Person person;
	
	@Test
	public void contextLoads() {
	 System.out.println(person.toString());
	}

}

