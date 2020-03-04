package com.tzx.blog.entity;

import java.util.Date;

import lombok.Data;

@Data
public class BlogInfo {
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
