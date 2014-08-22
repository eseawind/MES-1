package com.hilonggroupmes.dao.system.impl;

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

}
