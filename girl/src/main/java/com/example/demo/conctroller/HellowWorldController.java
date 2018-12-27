package com.example.demo.conctroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.HxdProperties;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.UserEntity;

@Controller  
public class HellowWorldController {
		@Autowired
		private HxdProperties hxdProperties;
		@Autowired
		private UserMapper userMapper;
		
	   @RequestMapping(value="/hello", method=RequestMethod.GET)  
	   @ResponseBody
	    public Object HelloController() {  
		 //  System.out.println(hxdProperties.getTitle());
		   UserEntity user=userMapper.getOne(1);
	       return user;  
	      /* ModelAndView mv=new ModelAndView();
	        mv.setViewName("index");
	        return mv;*/
	   }  
	   @RequestMapping(value="/index", method=RequestMethod.GET)  
	   public String index() {  
		   return "index";  
	   }  

	   	@RequestMapping("/getUser")
	   //	@Cacheable(value = "my-redis-cache1", key = "#id", unless = "#result eq null")
		@Cacheable(value = "my-redis-cache1", key = "#id")
	   	@ResponseBody
	    public UserEntity getUser(int id) {
		   UserEntity user=userMapper.getOne(id);
	    	System.out.println("从数据库取值");  
	        return user;
	    }
	    
	    @RequestMapping("/getUsers")
	    @ResponseBody
	    public List<UserEntity> getUsers() {
	    	List<UserEntity> users=userMapper.getAll();
	    	System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
	        return users;
	    }


}
