package com.tzx.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tzx.blog.entity.CategoryInfo;
import com.tzx.blog.entity.UserCateInfo;

@Mapper
public interface BlogCategoryDao {
	public List<CategoryInfo> findCategories();

	public List<UserCateInfo> findUserCates(String userId);

	public List<UserCateInfo> findUserFiles(String userId);
}
