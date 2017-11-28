package com.tzx.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tzx.blog.dao.UserDao;
import com.tzx.blog.model.Userinfo;
import com.tzx.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void findUserById(int userId) {

	}

	@Override
	public Userinfo findUserByAccount(String account) {
		Userinfo userinfo = userDao.findByUserAccount(account);
		return userinfo;

	}

}
