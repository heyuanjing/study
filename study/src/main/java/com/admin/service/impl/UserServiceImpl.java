package com.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dao.UserDao;
import com.admin.entity.User;
import com.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	public User getUserById(int id) {
		return dao.getUserById(id);
	}

}
