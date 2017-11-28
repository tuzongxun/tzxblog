package com.tzx.blog.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

	@Override
	public Map<String, Object> addUser(Userinfo userinfo, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userinfo.getUserAccount() == null || "".equals(userinfo.getUserAccount())) {
			map.put("resultCode", 1);
			map.put("message", "账号不能为空");
		} else if (userinfo.getUserPassword() == null || "".equals(userinfo.getUserPassword())) {
			map.put("resultCode", 2);
			map.put("message", "密码不能为空");
		} else if (userinfo.getUserEmail() == null || "".equals(userinfo.getUserEmail())) {
			map.put("resultCode", 3);
			map.put("message", "邮箱不能为空");
		} else {
			// 设置默认用户名
			userinfo.setUserName(userinfo.getUserAccount());
			Userinfo user = null;
			try {
				user = userDao.save(userinfo);
				map.put("resultCode", 0);
				request.getSession().setAttribute("user", user);
			} catch (Exception e) {
				// 用户名存在
				map.put("resultCode", 4);
				map.put("message", "用户已经存在");
			}
		}

		return map;
	}

}
