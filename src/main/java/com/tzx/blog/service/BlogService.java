package com.tzx.blog.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.ui.ModelMap;

import com.tzx.blog.model.Bloginfo;

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
	public Bloginfo findBlogById(int blogId, ModelMap map, HttpServletRequest request);

	public ModelMap findCategories(ModelMap map);

	/**
	 * 首页博客列表
	 * 
	 * @return
	 */
	public Page<Bloginfo> findBlogList();

	public void sysInfo(ModelMap map);
}
