package com.tzx.blog.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * blog实体
 * 
 */
@Entity
@NamedQuery(name = "Bloginfo.findAll", query = "SELECT b FROM Bloginfo b")
public class Bloginfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "blog_id")
	private int blogId;
	/**
	 * blog评论数
	 */
	@Column(name = "blog_commentcount")
	private BigInteger blogCommentCount;

	/**
	 * blog内容
	 */
	@Lob
	@Column(name = "blog_content")
	private String blogContent;
	/**
	 * blog最后修改时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "blog_date")
	private Date blogDate;
	/**
	 * blog阅读数
	 */
	@Column(name = "blog_readcount")
	private BigInteger blogReadCount;
	/**
	 * blog标题
	 */
	@Column(name = "blog_title")
	private String blogTitle;
	/**
	 * blog类型
	 */
	@Column(name = "blog_type")
	private String blogType;
	/**
	 * 用户id
	 */
	@Column(name = "user_id")
	private BigInteger userId;

	public Bloginfo() {
	}

	public int getBlogId() {
		return this.blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public BigInteger getBlogCommentCount() {
		return this.blogCommentCount;
	}

	public void setBlogCommentcount(BigInteger blogCommentCount) {
		this.blogCommentCount = blogCommentCount;
	}

	public String getBlogContent() {
		return this.blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public Date getBlogDate() {
		return this.blogDate;
	}

	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}

	public BigInteger getBlogReadCount() {
		return this.blogReadCount;
	}

	public void setBlogReadcount(BigInteger blogReadCount) {
		this.blogReadCount = blogReadCount;
	}

	public String getBlogTitle() {
		return this.blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogType() {
		return this.blogType;
	}

	public void setBlogType(String blogType) {
		this.blogType = blogType;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Bloginfo [blogId=" + blogId + ", blogCommentcount=" + blogCommentCount + ", blogContent=" + blogContent
				+ ", blogDate=" + blogDate + ", blogReadcount=" + blogReadCount + ", blogTitle=" + blogTitle
				+ ", blogType=" + blogType + ", userId=" + userId + "]";
	}

}