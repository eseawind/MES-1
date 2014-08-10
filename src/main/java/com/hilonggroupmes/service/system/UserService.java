package com.hilonggroupmes.service.system;

import java.util.List;

import com.hilonggroupmes.domain.system.UserInfo;

public interface UserService {
	
public void saveUser(UserInfo user);
	
	public void updateUser(UserInfo user);
	
	public UserInfo findUserById(Long id);
	
	public void deleteUser(UserInfo user);
	
	public List<UserInfo> findAllList();
	
	public UserInfo findUserByNameAndPassword(String username, String password);

}
