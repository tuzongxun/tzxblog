package com.tzx.blog.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tzx.blog.models.Userinfo;

/**
 * 用户信息持久化接口:使用jpa实现
 * 
 * @author tzx
 *
 */
@Repository
public interface UserDao extends JpaRepository<Userinfo, Integer> {
	public Userinfo findByUserId(int userId);
}
