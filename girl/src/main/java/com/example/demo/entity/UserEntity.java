package com.example.demo.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String userName;
	private String passWord;
	private Integer userSex;
	
	public UserEntity(Integer id,String userName, String passWord, Integer userSex) {
		this.id=id;
		this.userName = userName;
		this.passWord = passWord;
		this.userSex = userSex;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", userSex=" + userSex
				+ "]";
	}
	
}
