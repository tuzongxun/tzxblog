package com.tzx.blog.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tzx.blog.commons.TzxData;
import com.tzx.blog.models.Bloginfo;
import com.tzx.blog.services.BlogService;

/**
 * 首页
 * 
 * @author tzx
 *
 */
@Controller
public class IndexController {
	@Autowired
	BlogService blogService;

	@RequestMapping("/tzxblog")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		Bloginfo bloginfo = blogService.findBlogById(1);
		System.out.println(bloginfo);
		map.addAttribute("content", bloginfo.getBlogContent());
		map.addAttribute("title", bloginfo.getBlogTitle());
		map.addAttribute("type", bloginfo.getBlogType() == 0 ? "原创" : "转载");
		map.addAttribute("date", "发布时间：" + bloginfo.getBlogDate());
		map.addAttribute("readCount", "阅读量：" + bloginfo.getBlogReadcount());
		map.addAttribute("commentsCount", "评论数：" + bloginfo.getBlogCommentcount());
		map.addAttribute("readCounts", TzxData.readCounts);
		map.addAttribute("blogCounts", 2);
		map.addAttribute("myCounts", 1);
		map.addAttribute("otherCounts", 1);
		map.addAttribute("commentCounts", 99);

		return "index";
	}
}
