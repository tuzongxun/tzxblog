package com.tzx.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tzx.blog.dao.UserDao;
import com.tzx.blog.entity.UserInfo;
import com.tzx.blog.enums.ResponseEnum;
import com.tzx.blog.vo.TzxResVO;

@Service
public class UserService {

	@Value("${imgs.host}")
	private String host;
	@Value("${imgs.port}")
	private String port;
	@Autowired
	private UserDao userDao;

	public TzxResVO<UserInfo> findUser(String timestamp, String sign, String userId, String requestId) {
		TzxResVO<UserInfo> resVO = new TzxResVO<>();
		UserInfo userInfo = userDao.findUserById(userId);

		StringBuilder stringBuilder = new StringBuilder("http://");
		stringBuilder.append(host).append(":").append(port);
		userInfo.setImg(stringBuilder.append(userInfo.getImg()).toString());

		resVO.setCode(ResponseEnum.E000000.getCode());
		resVO.setMsg(ResponseEnum.E000000.getMsg());
		resVO.setRequestId(requestId);
		resVO.setBackData(userInfo);
		return resVO;
	}
}
