package com.tzx.blog.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tzx.blog.models.Commentinfo;
import com.tzx.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired

	@Override
	public List<Commentinfo> findCommentByBlogId(int blogId) {
		return null;
	}

}
