package com.tzx.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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

	/**
	 * 一个博客对应多个评论，关联字段commentinfo表中blog_id字段
	 */
	@JoinColumn(name = "blog_id")
	@OneToMany
	private List<Commentinfo> comList;

}