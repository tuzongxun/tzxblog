package com.tzx.blog.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.tzx.blog.commons.TzxData;
import com.tzx.blog.daos.BlogDao;
import com.tzx.blog.daos.UserDao;
import com.tzx.blog.models.Bloginfo;
import com.tzx.blog.models.Userinfo;
import com.tzx.blog.services.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDao blogDao;

	@Autowired
	UserDao userDao;

	@Override
	public ModelMap findBlogById(int blogId, ModelMap map) {
		long blogCounts = blogDao.count();
		Bloginfo bloginfo = blogDao.findByBlogId(blogId);
		Userinfo userinfo = userDao.findByUserId(Integer.parseInt(bloginfo
				.getUserId().toString()));
		System.out.println(bloginfo);
		map.addAttribute("readCounts", TzxData.readCounts);
		map.addAttribute("blogCounts", blogCounts);
		map.addAttribute("myCounts", 1);
		map.addAttribute("otherCounts", 1);
		map.addAttribute("commentCounts", 99);
		map.addAttribute("blogInfo", bloginfo);
		map.addAttribute("userInfo", userinfo);
		return map;
	}

	@Override
	public ModelMap findCategories(ModelMap map) {
		map.addAttribute("categories", "aaa");
		return map;
	}

}
