package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//mybatis使用
@MapperScan("com.example.demo.dao")
//有定时任务时 使用
@EnableScheduling
public class GirlApplication extends SpringBootServletInitializer  {
		
	/*  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(GirlApplication.class);
	    }*/
	
	public static void main(String[] args) {
		SpringApplication.run(GirlApplication.class, args);
	}
}
