package com.demo.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.demo.dao.IUserDao;
import com.demo.entity.User;

public class UserDao extends HibernateDaoSupport implements IUserDao {
	


	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		List<User> lsUser = (List<User>) this.getHibernateTemplate().find("from User");
		return lsUser;
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUserByName(String userName) {
		List<User> userSelect = (List<User>) this.getHibernateTemplate()
				.find("from User where username = '" + userName + "'");
		if (userSelect != null && userSelect.size() > 0) {
			return userSelect.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, Integer> getAuthority(String userName) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<Object> result = session.createQuery(
				"select a.screenId.screenId, a.authority from Authority a, Screen s, Role r,User u "
						+ "where u.username = :userName")
				.setString("userName", userName).list();

		Map<Integer, Integer> authoruty = new HashMap<Integer, Integer>();
		for (int i = 0; i < result.size(); i++){
			Object[] o = (Object[]) result.get(i);
			authoruty.put((Integer) o[0], (Integer) o[1]);
		}

		session.close();
		return authoruty;
	}

	@Override
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
		
	}

}
