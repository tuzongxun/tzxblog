package com.tzx.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tzx.blog.dao.CommentDao;
import com.tzx.blog.model.Commentinfo;
import com.tzx.blog.service.CommentService;
import com.tzx.blog.util.SendMailUtil;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;
	@Autowired
	SendMailUtil sendMailUtil;

	@Override
	public List<Commentinfo> findCommentByBlogId(Integer blogId) {
		return null;
	}

	@Override
	public void addComment(Commentinfo comment) {
		commentDao.save(comment);
		// 发邮件
		sendMailUtil.sendEmail(comment.getCommentContent());
	}

}
