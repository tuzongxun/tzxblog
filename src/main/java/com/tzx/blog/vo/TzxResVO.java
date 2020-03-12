package com.tzx.blog.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 统一返回值对象
 * 
 * @author 涂宗勋
 * @date 2020年3月3日
 * @email 1160569243@qq.com
 * @博客：tuzongxun.blog.csdn.net
 */
@Data
public class TzxResVO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 757054769809936203L;
	/**
	 * 响应码
	 */
	private String code;
	/**
	 * 响应描述
	 */
	private String msg;
	/**
	 * 请求id
	 */
	private String requestId;
	private T backData;
}
