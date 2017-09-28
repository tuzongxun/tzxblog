package com.tzx.blog.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * blog评论实体
 * 
 */
@Entity
@NamedQuery(name = "Commentinfo.findAll", query = "SELECT c FROM Commentinfo c")
public class Commentinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "comment_id")
	private int commentId;
	/**
	 * blog的id
	 */
	@Column(name = "blog_id")
	private BigInteger blogId;
	/**
	 * 评论内容
	 */
	@Column(name = "comment_content")
	private String commentContent;
	/**
	 * 评论时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "comment_date")
	private Date commentDate;
	/**
	 * 评论用户的id
	 */
	@Column(name = "user_id")
	private BigInteger userId;

	public Commentinfo() {
	}

	public int getCommentId() {
		return this.commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public BigInteger getBlogId() {
		return this.blogId;
	}

	public void setBlogId(BigInteger blogId) {
		this.blogId = blogId;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Commentinfo [commentId=" + commentId + ", blogId=" + blogId + ", commentContent=" + commentContent
				+ ", commentDate=" + commentDate + ", userId=" + userId + "]";
	}

}