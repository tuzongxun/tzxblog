package com.tzx.blog.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tzx.blog.entity.CategoryInfo;
import com.tzx.blog.entity.UserCateInfo;
import com.tzx.blog.service.CateService;
import com.tzx.blog.vo.TzxResVO;

import lombok.extern.slf4j.Slf4j;

/**
 * 分类操作接口
 * 
 * @author 涂宗勋
 * @date 2020年3月13日
 * @email 1160569243@qq.com
 * @博客：tuzongxun.blog.csdn.net
 */
@RestController
@Slf4j
@RequestMapping("/tzxblog/cate")
public class CategoryController {

	@Autowired
	private CateService cateService;

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
		return cateService.findCategories(requestId, timestamp, sign, queryType, userId);
	}

	/**
	 * 获取用户分类信息列表
	 * 
	 * @auth 涂宗勋
	 * @param timestamp
	 * @param sign
	 * @param userId
	 * @return
	 */
	@GetMapping("/user-cate-list")
	public TzxResVO<List<UserCateInfo>> findUserCates(@RequestHeader(required = false) String timestamp,
			@RequestHeader(required = false) String sign, String userId) {
		String requestId = UUID.randomUUID().toString();
		log.info("【用户分类查询请求】，入参：timestamp={},sign={},userId={},请求id：{}", timestamp, sign, userId, requestId);
		return cateService.findUserCates(timestamp, sign, userId, requestId);
	}

	/**
	 * 获取用户分类信息列表
	 * 
	 * @auth 涂宗勋
	 * @param timestamp
	 * @param sign
	 * @param userId
	 * @return
	 */
	@GetMapping("/user-file-list")
	public TzxResVO<List<UserCateInfo>> findUserFiles(@RequestHeader(required = false) String timestamp,
			@RequestHeader(required = false) String sign, String userId) {
		String requestId = UUID.randomUUID().toString();
		log.info("【用户归档查询请求】，入参：timestamp={},sign={},userId={},请求id：{}", timestamp, sign, userId, requestId);
		return cateService.findUserFiles(timestamp, sign, userId, requestId);
	}

}
