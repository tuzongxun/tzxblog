package com.tzx.blog.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BlogInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7392718228378268756L;
	private String id;
	private String title;
	private String desc;
	private String content;
	private String type;
	private UserInfo userInfo;
	private BlogDetailInfo blogDetailInfo;
	private String cateId;
	private Date createTime;
	private Date updateTime;

}
