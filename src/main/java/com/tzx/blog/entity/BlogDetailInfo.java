package com.tzx.blog.entity;

import lombok.Data;

@Data
public class BlogDetailInfo {
	private String id;
	private String blogId;
	private Integer fabulousCount;
	private Integer readCount;
	private Integer commentCount;
	private Integer forwardCount;
	private String cateType;
	private String power;
	private String blogType;
}
