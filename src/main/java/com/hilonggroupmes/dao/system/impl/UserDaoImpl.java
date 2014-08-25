package com.hilonggroupmes.dao.system.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.system.UserDao;
import com.hilonggroupmes.domain.system.UserInfo;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserInfo> implements UserDao {

	@Override
	public Long saveUser(UserInfo user) {
		return (Long)super.save(user);
	}

	@Override
	public UserInfo getUserByPassword(String user_accont, String user_password) {
		String []p_getUserByPassword = {user_accont,user_password};
		String h_getUserbyPassword = "from UserInfo user "
				                   + "where user.user_accont = ? "
				                   + "and user.user_password = ? ";
		return super.get(h_getUserbyPassword, p_getUserByPassword);
	}

	@Override
	public void deleteUserById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserInfo> getUsersByPage(Integer page, Integer rows,
			Map<String,Object> paremeters) {
        
		String h_getUserByPage = "from UserInfo user";
		List<Object> param = new ArrayList<Object>();
		if(!paremeters.isEmpty())
		{
			h_getUserByPage += " where ";
			int pareNum = paremeters.size();
			int i=1;
			for(String key:paremeters.keySet())
			{
				if(i!=pareNum)
				   h_getUserByPage += (key +"=? and ");
				else
				   h_getUserByPage += key + "=?";
				param.add(paremeters.get(key));
				i++;
			}			
		}
		return super.find(h_getUserByPage, param, page, rows);
	}
	
	@Override
	public Long getUsersNum(Map<String,Object> paremeters) {
        
		String h_getUserByPage = "select count(*) from UserInfo user";
		List<Object> param = new ArrayList<Object>();
		if(!paremeters.isEmpty())
		{
			h_getUserByPage += " where ";
			int pareNum = paremeters.size();
			int i=1;
			for(String key:paremeters.keySet())
			{
				if(i!=pareNum)
				   h_getUserByPage += (key +"=? and ");
				else
				   h_getUserByPage += key + "=?";
				param.add(paremeters.get(key));
				i++;
			}			
		}
		return super.count(h_getUserByPage, param);
	}

	@Override
	public void deleteUserByIds(String ids) {
		super.executeHql("delete from UserInfo user where user.user_id in(" + ids +")");
	}
	
	

}
