package com.tzx.blog.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
		blogService.findBlogById(1, map);
		return "index";
	}
}
