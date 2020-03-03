package com.tzx.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tzx.blog.dao.BlogCategoryDao;
import com.tzx.blog.entity.CategoryInfo;
import com.tzx.blog.enums.ResponseEnum;
import com.tzx.blog.vo.TzxResVO;

import lombok.extern.slf4j.Slf4j;

/**
 * 博客操作业务类
 * 
 * @author 涂宗勋
 * @date 2020年3月3日
 * @email 1160569243@qq.com
 * @博客：tuzongxun.blog.csdn.net
 */
@Slf4j
@Service
public class BlogService {
	@Autowired
	private BlogCategoryDao categoryDao;

	/**
	 * 博客分类查询
	 * 
	 * @auth 涂宗勋
	 * @param timestamp
	 * @param sign
	 * @param queryType
	 * @param userId
	 * @return
	 */
	public TzxResVO<List<CategoryInfo>> findCategories(String requestId, String timestamp, String sign,
			String queryType, String userId) {
		TzxResVO<List<CategoryInfo>> resVO = new TzxResVO<>();
		List<CategoryInfo> cateList = categoryDao.findCategories();
		System.out.println(cateList);

		resVO.setCode(ResponseEnum.E000000.getCode());
		resVO.setMsg(ResponseEnum.E000000.getMsg());
		resVO.setRequestId(requestId);
		resVO.setData(cateList);

		log.info("博客分类查询响应结果：{}", resVO);
		return resVO;
	}
}
