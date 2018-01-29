package com.guides.shared.session.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate redisTemlate;
	
	@Autowired
	private HttpSession seesion;

	
	@RequestMapping()
	public String index(String username ,String password) {
		
		System.out.println(" index ...");
		return "index!";
	}
	
	@RequestMapping("/login")
	public String login(String username ,String password) {
		seesion.setAttribute("username", username);
		seesion.setAttribute("password", password);
		System.out.println("this is login :" +username + "_"+ password);
		return "login success!";
	}
	
	
	@RequestMapping("/info")
	public String info() {
		
		System.out.println("this is info :" +seesion.getAttribute("username") + "_"+ seesion.getAttribute("password"));
		return "username:"+seesion.getAttribute("username") + " /n  password:"+seesion.getAttribute("password");
	}

}
