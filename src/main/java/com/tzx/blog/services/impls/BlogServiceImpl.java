package com.tzx.blog.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tzx.blog.daos.BlogDao;
import com.tzx.blog.models.Bloginfo;
import com.tzx.blog.services.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDao blogDao;

	@Override
	public Bloginfo findBlogById(int blogId) {
		return blogDao.findByBlogId(blogId);
	}

}
