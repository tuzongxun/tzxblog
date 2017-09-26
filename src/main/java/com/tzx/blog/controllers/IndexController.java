package com.tzx.blog.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * 
 * @author tzx
 *
 */
@Controller
public class IndexController {
	@RequestMapping("/tzxblog")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		map.addAttribute("host", "https://tuzongxun.github.io");
		// return "welcome to tzxblog";
		return "index";
	}
}
