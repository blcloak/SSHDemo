package com.demo.serviceimpl;

import java.util.List;
import java.util.Map;

import com.demo.dao.IUserDao;
import com.demo.entity.User;
import com.demo.service.IUserService;

public class UserService implements IUserService {
	private IUserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public List<User> getUsers(){
		return userDao.getUsers();
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserByName(String userName) {
		
		return userDao.getUserByName(userName);
	}

	@Override
	public Map<Integer, Integer> getAuthority(String userName) {
		
		return userDao.getAuthority(userName);
	}
	
	
	

}
