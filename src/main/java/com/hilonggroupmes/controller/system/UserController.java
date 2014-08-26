package com.hilonggroupmes.controller.system;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("loginUser.do")
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
	
	@RequestMapping("*/delUser.do")
	@ResponseBody
	public Map<String,Object> userDel(HttpServletRequest request){
		String userIds = request.getParameter("delids");
		resultinfo.clear();
        if(userService.deleteUserByIds(userIds))
        {
        	resultinfo.put("success", true);
            resultinfo.put("message","用户删除成功！");
        }
        else
        {
        	resultinfo.put("success", false);
        	resultinfo.put("message","用户删除失败！");
        }
		return resultinfo;		
	}
	
	@RequestMapping("*/saveUser.do")
	@ResponseBody
	public Map<String,Object> userSave(Long user_id,String user_name,
			                           String user_accont,String user_password,
			                           int user_role,boolean user_state){
		resultinfo.clear();
		UserInfo user =new UserInfo();
		user.setUser_accont(user_accont);
		user.setUser_name(user_name);
		user.setUser_password(user_password);
		user.setUser_role(user_role);
		user.setUser_state(user_state);
		if(user_id==null)
			userService.saveUser(user);
		else
		{
			user.setUser_id(user_id);
			userService.updateUser(user);
		}
        resultinfo.put("success", true);
        resultinfo.put("message","用户添加成功！");
		return resultinfo;		
	}
	
	@RequestMapping("*/loadUser.do")
	@ResponseBody
	public Map<String,Object> loadUser(HttpServletRequest request){
		resultinfo.clear();
		Long id =Long.parseLong(request.getParameter("id"));
		UserInfo user = userService.findUserById(id);
        resultinfo.put("user_id", user.getUser_id());
        resultinfo.put("user_accont", user.getUser_accont());
        resultinfo.put("user_name", user.getUser_name());
        resultinfo.put("user_password", user.getUser_password());
        resultinfo.put("user_role", user.getUser_role());
        resultinfo.put("user_state", user.getUser_state());
		return resultinfo;		
	}
	
	
	
}
