package com.tzx.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * blog实体
 * 
 */
@Data
@Entity
@NamedQuery(name = "Bloginfo.findAll", query = "SELECT b FROM Bloginfo b")
public class Bloginfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "blog_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@Temporal(TemporalType.DATE)
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
	 * 多个博客对应一个人，关联字段bloginfo表中user_id字段
	 */
	@JoinColumn(name = "user_id")
	@ManyToOne
	private Userinfo userinfo;

}