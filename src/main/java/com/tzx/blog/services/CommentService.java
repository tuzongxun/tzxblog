package com.tzx.blog.services;

import java.util.List;

import com.tzx.blog.models.Commentinfo;

/**
 * 评论信息处理业务层接口
 * 
 * @author tzx
 *
 */
public interface CommentService {
	public List<Commentinfo> findCommentByBlogId(Integer blogId);
}
