package com.hilonggroupmes.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hilonggroupmes.service.system.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login.do")
	public String userLogin(String user_accont,String user_password){
		String loginrs = "main";
		if(userService.findUserByNameAndPassword(user_accont, user_password)==null)
			loginrs = "error";
		return loginrs;
	}

}
