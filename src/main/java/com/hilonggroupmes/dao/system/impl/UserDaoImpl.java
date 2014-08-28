package com.hilonggroupmes.dao.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hilonggroupmes.dao.base.impl.BaseDaoImpl;
import com.hilonggroupmes.dao.system.UserDao;
import com.hilonggroupmes.domain.system.UserInfo;
import com.hilonggroupmes.utils.CommonUtils;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserInfo> implements UserDao {

	@Override
	public UserInfo getUserByPassword(String user_accont, String user_password) {
		String []p_getUserByPassword = {user_accont,user_password};
		String h_getUserbyPassword = "from UserInfo user "
				                   + "where user.user_accont = ? "
				                   + "and user.user_password = ? ";
		return super.get(h_getUserbyPassword, p_getUserByPassword);
	}

	@Override
	public List<UserInfo> getUsersByPage(Integer page, Integer rows,
			Map<String,Object> paremeters) {
        
		Map<String,Object> queryInfo = CommonUtils.buildQuery("UserInfo",paremeters);
        String hql_query = (String) queryInfo.get("hql_query");
        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.find(hql_query, pare_query, page, rows);
	}
	
	@Override
	public Long getUsersNum(Map<String,Object> paremeters) {
        
		Map<String,Object> queryInfo = CommonUtils.buildQuery("UserInfo",paremeters);
        String hql_query = (String) queryInfo.get("hql_query");
        List<Object> pare_query = (List<Object>) queryInfo.get("pare_query");
		return super.count(hql_query, pare_query);
	}

	@Override
	public void deleteUserByIds(String ids) {
		super.executeHql("delete from UserInfo user where user.user_id in(" + ids +")");
	}
	
	

}
