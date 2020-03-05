package com.tzx.blog.vo;

import java.util.List;

import lombok.Data;

@Data
public class PageInfo<T> {
	private Long pageIndex;
	private Long pageSize;
	private Long totalCount;
	private Long pageCount;
	private List<T> pageData;
}
