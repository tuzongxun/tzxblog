package com.tzx.blog.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CategoryInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7335939613530498339L;
	private String id;
	private String name;
	private String desc;
	private int order;
	private Date createTime;
	private Date updateTime;
}
