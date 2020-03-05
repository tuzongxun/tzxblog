package com.tzx.blog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "imgs")
@Data
public class ImgConfig {

	// 上传路径
	private String filepath;

}