package com.admin.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.dao.UserDao;
import com.admin.dao.tools.SessionFactoryBuilder;
import com.admin.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactoryBuilder sessionFactoryBuilder;

	public User getUserById(int id) {
		Object object = (User) sessionFactoryBuilder.get(User.class, id);
		if (null != object) {
			return (User) object;
		}
		return null;
	}
}
