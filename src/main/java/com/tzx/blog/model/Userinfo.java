package com.tzx.blog.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * 用户实体
 * 
 */
@Entity
@NamedQuery(name = "Userinfo.findAll", query = "SELECT u FROM Userinfo u")
public class Userinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	/**
	 * 账号
	 */
	@Column(name = "user_account")
	private String userAccount;
	/**
	 * 邮箱
	 */
	@Column(name = "user_email")
	private String userEmail;
	/**
	 * 用户名
	 */
	@Column(name = "user_name")
	private String userName;
	/**
	 * 密码
	 */
	@Column(name = "user_password")
	private String userPassword;
	/**
	 * 手机号
	 */
	@Column(name = "user_phone")
	private String userPhone;

	public Userinfo() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "Userinfo [userId=" + userId + ", userAccount=" + userAccount + ", userEmail=" + userEmail
				+ ", userName=" + userName + ", userPassword=" + userPassword + ", userPhone=" + userPhone + "]";
	}

}