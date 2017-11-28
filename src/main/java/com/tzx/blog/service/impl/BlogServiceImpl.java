package com.tzx.blog.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.tzx.blog.common.TzxData;
import com.tzx.blog.dao.BlogDao;
import com.tzx.blog.dao.UserDao;
import com.tzx.blog.model.Bloginfo;
import com.tzx.blog.model.Userinfo;
import com.tzx.blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDao blogDao;

	@Autowired
	UserDao userDao;

	@Override
	public ModelMap findBlogById(int blogId, ModelMap map, HttpServletRequest request) {
		long blogCounts = blogDao.count();
		Bloginfo bloginfo = blogDao.findByBlogId(blogId);
		Userinfo userinfo = userDao.findByUserId(Integer.parseInt(bloginfo.getUserId().toString()));
		map.addAttribute("readCounts", TzxData.readCounts);
		map.addAttribute("blogCounts", blogCounts);
		map.addAttribute("myCounts", 1);
		map.addAttribute("otherCounts", 1);
		map.addAttribute("commentCounts", 99);
		map.addAttribute("blogInfo", bloginfo);
		map.addAttribute("userInfo", userinfo);
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			map.addAttribute("islogin", true);
		} else {
			map.addAttribute("islogin", false);
		}
		return map;
	}

	@Override
	public ModelMap findCategories(ModelMap map) {
		map.addAttribute("categories", "aaa");
		return map;
	}

}
