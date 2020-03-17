package com.tzx.blog.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7707718811070368336L;
	private String id;
	private String account;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String img;
	private UserDetailInfo userDetailInfo;

}
