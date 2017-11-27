package com.tzx.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tzx.blog.model.Userinfo;

/**
 * user控制层
 * 
 * @author tzx
 *
 */
@Controller
@RequestMapping("tzxblog")
public class UserController {
	/**
	 * 用户登录页面
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping("/loginpage")
	public String loginpage(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		return "login";
	}

	/**
	 * 用户登录请求：@ResponseBody可以在使用template的情况下返回普通数据
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public int login(@RequestBody Userinfo user, HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		System.out.println(user);
		return 1;
	}
}
