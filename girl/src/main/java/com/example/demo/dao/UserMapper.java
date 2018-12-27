package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

@Repository
public interface UserMapper {

	//@Select("SELECT * FROM users")
	List<UserEntity> getAll();
	
	//@Select("SELECT * FROM users WHERE id = #{id}")
	//@Cacheable(value = "user", key = "#id", unless = "#result eq null")
	UserEntity getOne(Integer id);

	//@Insert("INSERT INTO users(userName,passWord,userSex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(UserEntity user);

	//@Update("UPDATE users SET userName=#{userName} WHERE id =#{id}")
	void update(UserEntity user);

	//@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Integer id);
	
}
