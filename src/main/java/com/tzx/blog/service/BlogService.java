package com.tzx.blog.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

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
	public ModelMap findBlogById(int blogId, ModelMap map, HttpServletRequest request);

	public ModelMap findCategories(ModelMap map);
}
