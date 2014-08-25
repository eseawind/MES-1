package com.hilonggroupmes.controller.system;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hilonggroupmes.domain.system.UserInfo;
import com.hilonggroupmes.service.system.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private Map<String,Object> resultinfo = new HashMap<String,Object>();
	
	@RequestMapping("/loginUser.do")
	@ResponseBody
	public Map<String,Object> userLogin(String user_accont,String user_password){		
		
		resultinfo.clear();
		UserInfo crus = userService.findUserByNameAndPassword(user_accont, user_password);
		if(crus==null)
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
	
	@RequestMapping("*/listUser.do")
	@ResponseBody
	public Map<String,Object> userList(int page,int rows,String user_accont,String user_name){		
		resultinfo.clear();
		Map<String,Object> queryPare = new HashMap<String,Object>();
		if(user_accont!=null)
			queryPare.put("user_accont", user_accont);
		if(user_name!=null)
		    queryPare.put("user_name", user_name);
		resultinfo.put("total", userService.getUserNum(queryPare));
		resultinfo.put("rows", userService.findUserByPage(page, rows, queryPare));
		return resultinfo;		
	}
}
