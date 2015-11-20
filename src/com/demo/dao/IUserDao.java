package com.demo.dao;

import java.util.List;

import com.demo.entity.User;

public interface IUserDao {
	public void addUser(User user);
	public List<User> getUsers();
	public User getUserByName(String userName);
}
