package com.hilonggroupmes.controller.system;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hilonggroupmes.service.system.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login.do")
	@ResponseBody
	public Map<String,Object> userLogin(String user_accont,String user_password){
		Map<String,Object> resultinfo = new HashMap<String,Object>();
		if(userService.findUserByNameAndPassword(user_accont, user_password)==null)
		{
			resultinfo.put("success", false);
			resultinfo.put("message", "用户名或者密码错误！");
		}else
		{
		   resultinfo.put("success", true);
		   resultinfo.put("message", "page/main.jsp");
		}
		return resultinfo;
	}
}
