package com.tzx.blog.enums;

import lombok.Getter;

/**
 * 响应码映射枚举类
 * 
 * @author 涂宗勋
 * @date 2020年3月3日
 * @email 1160569243@qq.com
 * @博客：tuzongxun.blog.csdn.net
 */
@Getter
public enum ResponseEnum {
	E000000("000000", "SUCCESS"), E000001("000001", "系统异常");

	private String code;
	private String msg;

	private ResponseEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
