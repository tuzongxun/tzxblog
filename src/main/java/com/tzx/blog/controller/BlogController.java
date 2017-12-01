package com.tzx.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tzx.blog.model.Bloginfo;
import com.tzx.blog.model.Userinfo;
import com.tzx.blog.service.BlogService;

/**
 * blog控制层
 * 
 * @author tzx
 *
 */
@Controller
@RequestMapping("tzxblog")
public class BlogController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	BlogService blogService;

	/**
	 * 博客首页
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping("")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		log.warn("操作：{}", "首页访问");
		blogService.sysInfo(map);
		Page<Bloginfo> blogPage = blogService.findBlogList();
		map.put("blogList", blogPage.getContent());
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("user") == null) {
			map.addAttribute("islogin", false);
		} else {
			map.addAttribute("islogin", true);
			map.addAttribute("logUser", (Userinfo) session.getAttribute("user"));
		}
		return "index";
	}

	/**
	 * 博客分类
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping("categories")
	public String categories(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		log.warn("操作：{}", "分类页访问");
		blogService.findCategories(map);
		return "categories";
	}

	@RequestMapping(value = "openBlog", method = RequestMethod.POST)
	@ResponseBody
	public Bloginfo openBlog(Integer blogId, ModelMap map, HttpServletRequest request) {
		Bloginfo bloginfo = blogService.findBlogById(blogId, map, request);
		return bloginfo;
	}
}
