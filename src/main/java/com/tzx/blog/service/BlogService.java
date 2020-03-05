package com.tzx.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tzx.blog.dao.BlogCategoryDao;
import com.tzx.blog.dao.BlogInfoDao;
import com.tzx.blog.entity.BlogInfo;
import com.tzx.blog.entity.CategoryInfo;
import com.tzx.blog.entity.UserInfo;
import com.tzx.blog.enums.ResponseEnum;
import com.tzx.blog.vo.PageInfo;
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
	@Autowired
	private BlogInfoDao blogInfoDao;
	@Value("${imgs.host}")
	private String host;
	@Value("${imgs.port}")
	private String port;

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

	public TzxResVO<PageInfo<BlogInfo>> findBlogList(String timestamp, String sign, String queryType, Long pageIndex,
			Long pageSize, String userId, String cateId, String requestId) {
		TzxResVO<PageInfo<BlogInfo>> resVO = new TzxResVO<>();
		PageInfo<BlogInfo> pageInfo = new PageInfo<>();

		if (pageIndex == null || pageIndex == 0) {
			pageIndex = 1L;
		}
		if (pageSize == null || pageSize == 0) {
			pageSize = 5L;
		}
		long startPage = (pageIndex - 1) * pageSize;

		int totalCount = blogInfoDao.count(userId, cateId);

		List<BlogInfo> blogList = blogInfoDao.findBlogListByOtherId(null, cateId, startPage, pageSize, queryType);
		for (BlogInfo blog : blogList) {
			UserInfo userInfo = blog.getUserInfo();
			StringBuilder stringBuilder = new StringBuilder("http://");
			stringBuilder.append(host).append(":").append(port);
			userInfo.setImg(stringBuilder.append(userInfo.getImg()).toString());
		}

		long pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;

		pageInfo.setPageCount(new Long(pageCount));

		pageInfo.setPageIndex(pageIndex);
		pageInfo.setPageSize(new Long(blogList.size()));
		pageInfo.setPageData(blogList);
		pageInfo.setTotalCount(new Long(totalCount));

		resVO.setCode(ResponseEnum.E000000.getCode());
		resVO.setMsg(ResponseEnum.E000000.getMsg());
		resVO.setRequestId(requestId);
		resVO.setData(pageInfo);
		log.info("博客列表查询响应结果：{}", resVO);
		return resVO;
	}

}
