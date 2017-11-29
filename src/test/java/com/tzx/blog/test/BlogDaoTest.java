package com.tzx.blog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tzx.blog.dao.BlogDao;
import com.tzx.blog.model.Bloginfo;

/**
 * 博客dao测试
 * 
 * @author tzx
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogDaoTest {
	@Autowired
	BlogDao blogDao;

	@Test
	public void blogTest() {
		Bloginfo bloginfo = blogDao.findByBlogId(1);
		System.out.println(bloginfo);
	}
}
