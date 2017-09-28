package com.tzx.blog.services;

import com.tzx.blog.models.Bloginfo;

/**
 * blog信息处理业务层接口
 * 
 * @author tzx
 *
 */
public interface BlogService {
	/**
	 * 查询blog明细
	 */
	public Bloginfo findBlogById(int blogId);
}
