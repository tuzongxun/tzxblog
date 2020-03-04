package com.tzx.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tzx.blog.entity.UserInfo;

@Mapper
public interface UserDao {
	public UserInfo findUserById(@Param("id") String id);
}
