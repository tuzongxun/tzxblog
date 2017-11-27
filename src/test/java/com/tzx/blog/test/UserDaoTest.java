package com.tzx.blog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tzx.blog.dao.UserDao;
import com.tzx.blog.model.Userinfo;

/**
 * 用户信息持久化接口测试
 * 
 * @author tzx
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	@Autowired
	UserDao userDao;

	/**
	 * 根据用户id查询用户信息测试
	 */
	@Test
	public void userDaoTest() {
		Userinfo userinfo = userDao.findByUserId(1);
		System.out.println(userinfo);
	}

}
