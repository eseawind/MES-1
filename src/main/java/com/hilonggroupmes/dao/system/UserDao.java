package com.hilonggroupmes.dao.system;

import com.hilonggroupmes.dao.base.BaseDao;
import com.hilonggroupmes.domain.system.UserInfo;

public interface UserDao extends BaseDao<UserInfo> {
	
	public Long saveUser(UserInfo user);
	
	public UserInfo getUserByPassword(String user_accont,String user_password);
	
	public void deleteUserById();

}
