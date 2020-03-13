package com.tzx.blog.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tzx.blog.entity.UserInfo;
import com.tzx.blog.service.UserService;
import com.tzx.blog.vo.TzxResVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("tzxblog/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/userinfo")
	public TzxResVO<UserInfo> findUser(@RequestHeader(required = false) String timestamp,
			@RequestHeader(required = false) String sign, String userId) {
		String requestId = UUID.randomUUID().toString();
		log.info("【用户信息查询请求】，入参：timestamp={},sign={},userId={},请求id：{}", timestamp, sign, userId, requestId);
		return userService.findUser(timestamp, sign, userId, requestId);
	}
}
