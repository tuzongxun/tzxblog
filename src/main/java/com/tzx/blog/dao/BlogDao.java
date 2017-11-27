package com.tzx.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tzx.blog.model.Bloginfo;

/**
 * 博客信息持久化接口
 * 
 * @author tzx
 *
 */
@Repository
public interface BlogDao extends JpaRepository<Bloginfo, Integer> {
	/**
	 * 根据blogid查询blog信息
	 * 
	 * @param blogId
	 * @return
	 */
	public Bloginfo findByBlogId(int blogId);
}
