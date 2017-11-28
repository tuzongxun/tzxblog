package com.tzx.blog.service;

import java.util.Map;

import com.tzx.blog.model.Userinfo;

/**
 * 用户信息处理业务层接口
 * 
 * @author tzx
 *
 */
public interface UserService {
	public void findUserById(int userId);

	/**
	 * 根据account查询用户信息
	 * 
	 * @param account
	 * @return
	 */
	public Userinfo findUserByAccount(String account);

	/**
	 * 用户注册
	 * 
	 * @param userinfo
	 * @return
	 */
	public Map<String, Object> addUser(Userinfo userinfo);
}
