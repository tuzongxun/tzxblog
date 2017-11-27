package com.tzx.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tzx.blog.model.Commentinfo;
import com.tzx.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	// @Autowired

	@Override
	public List<Commentinfo> findCommentByBlogId(Integer blogId) {
		return null;
	}

}
