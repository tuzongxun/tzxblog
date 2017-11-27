package com.tzx.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tzx.blog.model.Userinfo;

/**
 * 用户信息持久化接口:使用jpa实现
 * 
 * @author tzx
 *
 */
@Repository
public interface UserDao extends JpaRepository<Userinfo, Integer> {
	/**
	 * 根据userid查询user信息
	 * 
	 * @param userId
	 * @return
	 */
	public Userinfo findByUserId(int userId);
}
