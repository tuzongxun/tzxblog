package com.tzx.blog.services;

import com.tzx.blog.models.Commentinfo;

/**
 * 评论信息处理业务层接口
 * 
 * @author tzx
 *
 */
public interface CommentService {
	public Commentinfo findCommentById(int commentId);
}
