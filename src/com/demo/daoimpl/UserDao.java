package com.demo.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.demo.dao.IUserDao;
import com.demo.entity.User;

public class UserDao extends HibernateDaoSupport implements IUserDao {
	
	
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		List<User> lsUser = (List<User>) this.getHibernateTemplate().find("from User");
		return lsUser;
	}

	@Override
	public User getUserByName(String userName) {
		@SuppressWarnings("unchecked")
		List<User> userSelect = (List<User>) this.getHibernateTemplate().find("from User where username = '" + userName + "'");
		if(userSelect != null && userSelect.size() > 0){
			return userSelect.get(0);
		}
		return null;
	}
	
	
	
}
