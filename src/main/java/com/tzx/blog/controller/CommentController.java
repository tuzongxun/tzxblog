package com.tzx.blog.controller;

import java.math.BigInteger;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tzx.blog.model.Bloginfo;
import com.tzx.blog.model.Commentinfo;
import com.tzx.blog.service.CommentService;

/**
 * 评论控制层
 * 
 * @author tzx
 * @date 2018年1月29日
 */
@Slf4j
@Controller
@RequestMapping("tzxblog")
public class CommentController {
	// private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CommentService commentService;

	/**
	 * 添加评论
	 * 
	 * @param request
	 * @param comment
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "pushcomment", method = RequestMethod.POST)
	@ResponseBody
	public String pushComment(String comment, ModelMap map, HttpServletRequest request) {
		log.warn("操作：{}", "添加评论");
		System.out.println(comment);
		Commentinfo commentInfo = new Commentinfo();
		Bloginfo bloginfo = new Bloginfo();
		bloginfo.setBlogId(1);
		commentInfo.setBlogInfo(bloginfo);
		commentInfo.setCommentContent(comment);
		commentInfo.setCommentDate(new Date());
		commentInfo.setCommentId(1);
		BigInteger bigInteger = new BigInteger("1");
		commentInfo.setUserId(bigInteger);
		commentService.addComment(commentInfo);
		// blogService.findCategories(map);
		return "success";
	}

}
