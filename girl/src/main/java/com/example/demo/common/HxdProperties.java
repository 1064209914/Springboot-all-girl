package com.example.demo.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = "classpath:application.properties")
@Component
public class HxdProperties {

	@Value("${com.hxd.title}")
	private  String title;
	@Value("${com.hxd.description}")
	private  String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

	
}
