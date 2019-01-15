package com.example.config.bean;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="person")
//@Configuration
//@PropertySource(value="classpath:person.properties")
public class Person {
 
	//@Value("${person.name}")
	private String name;
	private int age;
	private Dog dog;
	private Map<String, String> map;
	private List<String> list;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", dog=" + dog + ", map=" + map + ", list=" + list + "]";
	}
	
}
