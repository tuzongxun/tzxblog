package com.tzx.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tzx.blog.dao.BlogCategoryDao;
import com.tzx.blog.entity.CategoryInfo;
import com.tzx.blog.entity.UserCateInfo;
import com.tzx.blog.enums.ResponseEnum;
import com.tzx.blog.vo.TzxResVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CateService {

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

		if ("user".equals(queryType)) {
			categoryDao.findCategories();
		}

		resVO.setCode(ResponseEnum.E000000.getCode());
		resVO.setMsg(ResponseEnum.E000000.getMsg());
		resVO.setRequestId(requestId);
		resVO.setBackData(cateList);

		log.info("博客分类查询响应结果：{}", resVO);
		return resVO;
	}

	public TzxResVO<List<UserCateInfo>> findUserCates(String timestamp, String sign, String userId, String requestId) {
		TzxResVO<List<UserCateInfo>> resVO = new TzxResVO<>();

		List<UserCateInfo> cateInfos = categoryDao.findUserCates(userId);
		resVO.setCode(ResponseEnum.E000000.getCode());
		resVO.setMsg(ResponseEnum.E000000.getMsg());
		resVO.setRequestId(requestId);
		resVO.setBackData(cateInfos);
		return resVO;
	}

	public TzxResVO<List<UserCateInfo>> findUserFiles(String timestamp, String sign, String userId, String requestId) {
		TzxResVO<List<UserCateInfo>> resVO = new TzxResVO<>();

		List<UserCateInfo> cateInfos = categoryDao.findUserFiles(userId);
		System.out.println(cateInfos);
		resVO.setCode(ResponseEnum.E000000.getCode());
		resVO.setMsg(ResponseEnum.E000000.getMsg());
		resVO.setRequestId(requestId);
		resVO.setBackData(cateInfos);
		return resVO;
	}
}
