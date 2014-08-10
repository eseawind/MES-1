package com.hilonggroupmes.service.system.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hilonggroupmes.dao.system.UserDao;
import com.hilonggroupmes.domain.system.UserInfo;
import com.hilonggroupmes.service.system.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;


	@Override
	public void saveUser(UserInfo user) {
		userDao.saveUser(user);
	}

	@Override
	public void updateUser(UserInfo user) {
		//userDao.update(user);
	}

	@Override
	public UserInfo findUserById(Long id) {
		return null;//userDao.get(UserInfo.class, id);
	}

	@Override
	public void deleteUser(UserInfo user) {
		//userDao.delete(user);
	}

	@Override
	public List<UserInfo> findAllList() {
		return null;//userDao.find(" from UserInfo u");
	}

	@Override
	public UserInfo findUserByNameAndPassword(String user_accont, String user_password) {
		return userDao.getUserByPassword(user_accont, user_password);
	}

}
