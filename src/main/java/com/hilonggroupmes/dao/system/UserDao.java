package com.hilonggroupmes.dao.system;

import java.util.List;
import java.util.Map;

import com.hilonggroupmes.dao.base.BaseDao;
import com.hilonggroupmes.domain.system.UserInfo;

public interface UserDao extends BaseDao<UserInfo> {
	
	public Long saveUser(UserInfo user);
	
	public UserInfo getUserByPassword(String user_accont,String user_password);
	
	public void deleteUserById();
	
	public List<UserInfo> getUsersByPage(Integer page,Integer rows,Map<String,Object> paremeters);

	public Long getUsersNum(Map<String,Object> paremeters);
}
