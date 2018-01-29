package com.tzx.blog.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 自定义邮箱认证信息类
 * 
 * @author tzx
 * @date 2018年1月29日
 */
public class MailAuthenticator extends Authenticator {

  /**
  * 用户名
  */
  private String username;
  /**
  * 密码
  */
  private String password;

  /**
   * 创建一个新的实例 MailAuthenticator.
   * 
   * @param username
   * @param password
   */
  public MailAuthenticator(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  @Override
  protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
  }

  public String getUsername() {
    return username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

}
