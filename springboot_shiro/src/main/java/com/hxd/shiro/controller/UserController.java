package com.hxd.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/testThymeleaf")
    public String index() {
        return "index";
    }
	
	@RequestMapping("/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }
    
    @RequestMapping("/login")
    public String login(String username,String password,Model model) {
        /**
         * 使用shiro编写认证操作
         */
        //获取Subject
        Subject subject=SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        //执行登录方法
        try {
            //只要执行login方法，就会去执行UserRealm中的认证逻辑
            subject.login(token);

            //如果没有异常，代表登录成功
            //跳转到textThymeleaf页面，代表主页
            return "redirect:/testThymeleaf";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            //登录失败
            model.addAttribute("msg","用户名不存在");
            return "login";

        }catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
    
}
