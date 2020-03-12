package com.tzx.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tzx.blog.entity.BlogInfo;

@Mapper
public interface BlogInfoDao {
	public List<BlogInfo> findBlogListByOtherId(@Param("userId") String userId, @Param("cateId") String cateId,
			@Param("startPage") Long startPage, @Param("pageSize") Long pageSize, @Param("cateType") String cateType);

	public int count(@Param("userId") String userId, @Param("cateId") String cateId);

	public BlogInfo findBlogDetail(@Param("blogId") String blogId);
}
