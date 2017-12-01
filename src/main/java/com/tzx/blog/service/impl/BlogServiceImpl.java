package com.tzx.blog.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.tzx.blog.common.TzxData;
import com.tzx.blog.dao.BlogDao;
import com.tzx.blog.model.Bloginfo;
import com.tzx.blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDao blogDao;

	@Override
	public Bloginfo findBlogById(int blogId, ModelMap map, HttpServletRequest request) {
		Bloginfo bloginfo = blogDao.findByBlogId(blogId);
		return bloginfo;
	}

	@Override
	public ModelMap findCategories(ModelMap map) {
		map.addAttribute("categories", "aaa");
		return map;
	}

	@Override
	public Page<Bloginfo> findBlogList() {
		Sort sort = new Sort(Direction.DESC, "blogDate");
		Pageable pageable = new PageRequest(0, 10, sort);
		Page<Bloginfo> blogPage = blogDao.findAll(pageable);
		return blogPage;
	}

	/**
	 * 网站整体信息查询
	 * 
	 * @return
	 */
	@Override
	public void sysInfo(ModelMap map) {
		// Map<String, Long> map = new HashMap<String, Long>();
		// 查询博客总数
		long blogCount = blogDao.count();
		// 查询原创总数
		long myCount = blogDao.countByBlogType("原创");
		map.addAttribute("readCounts", TzxData.readCounts);
		map.addAttribute("blogCounts", blogCount);
		map.addAttribute("myCounts", myCount);
		map.addAttribute("otherCounts", blogCount - myCount);
	}

}
