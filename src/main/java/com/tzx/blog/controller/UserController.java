package com.tzx.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tzx.blog.model.Userinfo;
import com.tzx.blog.service.UserService;

/**
 * user控制层
 * 
 * @author tzx
 *
 */
@Controller
@RequestMapping("tzxblog")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	/**
	 * 用户登录页面
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping("/loginpage")
	public String loginpage() {
		return "login";
	}

	/**
	 * 用户登录请求：@ResponseBody可以在使用template的情况下返回普通数据
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @param map
	 * @return 0:登录成功，1：用户名不能为空，2：用户名不存在，3：密码错误
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Map<String, Object> login(@RequestBody Userinfo user, HttpServletRequest request) {
		logger.warn("操作：{}", "登录");
		Map<String, Object> map = new HashMap<String, Object>();
		if (user == null || user.getUserAccount() == null || "".equals(user.getUserAccount())) {
			map.put("resCode", 1);
			return map;
		}
		Userinfo userinfo = userService.findUserByAccount(user.getUserAccount());
		if (userinfo == null) {
			map.put("resCode", 2);
			return map;
		} else if (!(userinfo.getUserPassword().equals(user.getUserPassword()))) {
			map.put("resCode", 3);
			return map;
		}
		System.out.println("user:" + request.getSession().getId());
		request.getSession().setAttribute("user", userinfo);
		logger.warn("用户登录成功：{},{}", new Object[] { userinfo.getUserAccount(), userinfo.getUserName() });
		map.put("resCode", 0);
		return map;
	}

	/**
	 * 注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "registpage")
	public String registpage() {
		return "regist";
	}

	/**
	 * 注册
	 * 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "regist", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object regist(@RequestBody Userinfo user, HttpServletRequest request) {
		logger.warn("操作：{}", "用户注册");
		Map<String, Object> map = userService.addUser(user, request);
		return map;
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		try {
			response.sendRedirect("/tzxblog");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("用户退出异常：{},{}", e);
		}
	}

}
