package com.tzx.blog.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tzx.blog.commons.TzxData;
import com.tzx.blog.services.BlogService;

/**
 * 首页
 * 
 * @author tzx
 *
 */
@Controller
public class IndexController {
	@Autowired
	BlogService blogService;

	@RequestMapping("/tzxblog")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		blogService.findBlogInfo(1);
		map.addAttribute("context", "  少发了卡萨缴费基数龙卷风拉斯加老房间爱睡懒觉法拉受精卵放假啊刷积分" + "\r\n"
				+ "  松岛枫红啊是佛山大佛横扫风hi啊是覅哦啊手覅哈达神佛哈度搜凤凰IOS大会发送阿迪神佛啊是覅哦哈搜ifhi阿搜房hi噢啊但是覅哦哈死哦发哈第三方" + "\r\n"
				+ "  说的佛哈桑佛i哈桑粉红色哈佛横扫的分红阿斯顿回复撒地方考虑将撒旦法卢卡斯将风口浪尖撒旦浪费将拉动神经分裂框架ADSL放假三等奖费卢卡斯金风科技阿迪刷积分卡受精卵风景奥德赛 加快速度龙卷风卢卡斯交罚款老家啊时空裂缝金卡戴珊将法拉第神经分裂刷积分卡拉斯积分卡拉斯加风口浪尖阿杜说考虑房价卡萨拉飞机撒地方将卡拉水井坊拉德斯基风口浪尖奥德赛"
				+ "\r\n"
				+ "  发大水考虑将罚款拉萨缴费逻辑爱的世界法拉第神经分裂撒地方考虑将ADSL风景扣篮大赛交罚款老家啊第三款放假撒旦浪费空间阿迪刷积分卡拉斯加贷款方金卡戴珊放假三大块浪费将拉动刷积分卡拉到啥风口浪尖"
				+ "\r\n"
				+ "  发大水考虑将罚款拉萨缴费逻辑爱的世界法拉第神经分裂撒地方考虑将ADSL风景扣篮大赛交罚款老家啊第三款放假撒旦浪费空间阿迪刷积分卡拉斯加贷款方金卡戴珊放假三大块浪费将拉动刷积分卡拉到啥风口浪尖"
				+ "\r\n"
				+ "  发大水考虑将罚款拉萨缴费逻辑爱的世界法拉第神经分裂撒地方考虑将ADSL风景扣篮大赛交罚款老家啊第三款放假撒旦浪费空间阿迪刷积分卡拉斯加贷款方金卡戴珊放假三大块浪费将拉动刷积分卡拉到啥风口浪尖"
				+ "\r\n"
				+ "  发大水考虑将罚款拉萨缴费逻辑爱的世界法拉第神经分裂撒地方考虑将ADSL风景扣篮大赛交罚款老家啊第三款放假撒旦浪费空间阿迪刷积分卡拉斯加贷款方金卡戴珊放假三大块浪费将拉动刷积分卡拉到啥风口浪尖"
				+ "\r\n"
				+ "  发大水考虑将罚款拉萨缴费逻辑爱的世界法拉第神经分裂撒地方考虑将ADSL风景扣篮大赛交罚款老家啊第三款放假撒旦浪费空间阿迪刷积分卡拉斯加贷款方金卡戴珊放假三大块浪费将拉动刷积分卡拉到啥风口浪尖");
		map.addAttribute("title", "this is my first blog , welcome");
		map.addAttribute("type", "原创");
		map.addAttribute("date", "发布时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		map.addAttribute("readCount", "阅读量：" + 999);
		map.addAttribute("commentsCount", "评论数：" + 99);
		map.addAttribute("readCounts", TzxData.readCounts);
		map.addAttribute("blogCounts", 2);
		map.addAttribute("myCounts", 1);
		map.addAttribute("otherCounts", 1);
		map.addAttribute("commentCounts", 99);

		// return "welcome to tzxblog";
		return "index";
	}
}
