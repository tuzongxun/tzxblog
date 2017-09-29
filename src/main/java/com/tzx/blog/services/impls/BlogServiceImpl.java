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
		Userinfo userinfo = userDao.findByUserId(Integer.parseInt(bloginfo.getUserId().toString()));
		System.out.println(bloginfo);
		map.addAttribute("content", bloginfo.getBlogContent());
		map.addAttribute("title", bloginfo.getBlogTitle());
		map.addAttribute("type", bloginfo.getBlogType() == 0 ? "原创" : "转载");
		map.addAttribute("date", "发布时间：" + bloginfo.getBlogDate());
		map.addAttribute("readCount", "阅读量：" + bloginfo.getBlogReadcount());
		map.addAttribute("commentsCount", "评论数：" + bloginfo.getBlogCommentcount());
		map.addAttribute("readCounts", TzxData.readCounts);
		map.addAttribute("blogCounts", blogCounts);
		map.addAttribute("myCounts", 1);
		map.addAttribute("otherCounts", 1);
		map.addAttribute("commentCounts", 99);
		return map;
	}
}
