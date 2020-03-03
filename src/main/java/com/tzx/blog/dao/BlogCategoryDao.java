package com.tzx.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tzx.blog.entity.CategoryInfo;

@Mapper
public interface BlogCategoryDao {
	public List<CategoryInfo> findCategories();
}
