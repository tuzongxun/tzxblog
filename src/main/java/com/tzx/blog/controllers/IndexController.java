package com.tzx.blog.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tzx.blog.models.Userinfo;
import com.tzx.blog.services.BlogService;

/**
 * 首页
 * 
 * @author tzx
 *
 */
@Controller
@RequestMapping("tzxblog")
public class IndexController {
	@Autowired
	BlogService blogService;

	@RequestMapping("")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		blogService.findBlogById(1, map);
		return "index";
	}

	@RequestMapping("/categories")
	public String categories(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		blogService.findCategories(map);
		return "categories";
	}

	@RequestMapping("/loginpage")
	public String loginpage(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public int login(@RequestBody Userinfo user, HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		System.out.println(user);
		return 1;
	}
}
