package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.entity.User;

public interface IUserService {
	public void addUser(User user);
	public List<User> getUsers();
	public User getUserByName(String userName);
	public Map<Integer, Integer> getAuthority(String userName) ;
}
