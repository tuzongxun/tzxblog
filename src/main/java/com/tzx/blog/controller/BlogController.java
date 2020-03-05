package com.tzx.blog.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tzx.blog.entity.BlogInfo;
import com.tzx.blog.entity.CategoryInfo;
import com.tzx.blog.service.BlogService;
import com.tzx.blog.vo.PageInfo;
import com.tzx.blog.vo.TzxResVO;

import lombok.extern.slf4j.Slf4j;

/**
 * 博客操作接口
 * 
 * @author 涂宗勋
 * @date 2020年3月3日
 * @email 1160569243@qq.com
 * @博客：tuzongxun.blog.csdn.net
 */
@RestController
@Slf4j
@CrossOrigin(value = "http://localhost:8088")
@RequestMapping("/tzxblog/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	/**
	 * 分类信息查询：queryType：index:首页； user:用户； recom:推荐；hot:热门； file:归档
	 * 
	 * @auth 涂宗勋
	 * @param timestamp
	 * @param sign
	 * @param queryType
	 * @param userId
	 * @return
	 */
	@GetMapping("/category-list")
	public TzxResVO<List<CategoryInfo>> findCategories(@RequestHeader(required = false) String timestamp,
			@RequestHeader(required = false) String sign, String queryType,
			@RequestParam(required = false) String userId) {
		String requestId = UUID.randomUUID().toString();
		log.info("【博客分类查询请求】，入参：timestamp={},sign={},queryType={},userId={},请求id：{}", timestamp, sign, queryType,
				userId, requestId);
		return blogService.findCategories(requestId, timestamp, sign, queryType, userId);
	}

	/**
	 * 博客列表分页查询 queryType String Y
	 * index:首页；user:用户；recom:推荐；hot:活动；file:归档；notice：公告 pageIndex Long N 页码，默认1
	 * pagSize Long N 页数，默认10 userId
	 * 
	 * @auth 涂宗勋
	 * @param timestamp
	 * @param sign
	 * @param cateId
	 * @return
	 */
	@GetMapping("/blog-list")
	public TzxResVO<PageInfo<BlogInfo>> findBlogList(@RequestHeader(required = false) String timestamp,
			@RequestHeader(required = false) String sign, String queryType,
			@RequestParam(required = false) Long pageIndex, @RequestParam(required = false) Long pageSize,
			@RequestParam(required = false) String userId, @RequestParam(required = false) String cateId) {
		String requestId = UUID.randomUUID().toString();
		log.info("【博客列表查询请求】，入参：timestamp={},sign={},queryType={},pageIndex={},pageSize={},userId={},cateId={},请求id：{}",
				timestamp, sign, queryType, pageIndex, pageSize, userId, cateId, requestId);
		return blogService.findBlogList(timestamp, sign, queryType, pageIndex, pageSize, userId, cateId, requestId);
	}

}
