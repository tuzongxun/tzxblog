package com.tzx.blog.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDetailInfo implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -979499966138317225L;

	private String id;
	private Integer followmeCount;
	private Integer mefollowCount;
	private Integer blogCount;
	private Integer rdBlogCount;

}
