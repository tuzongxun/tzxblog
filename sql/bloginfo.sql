/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : tzxblog

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2020-03-04 11:15:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bloginfo
-- ----------------------------
DROP TABLE IF EXISTS `bloginfo`;
CREATE TABLE `bloginfo` (
  `id` bigint(20) NOT NULL,
  `content` text NOT NULL,
  `title` varchar(225) NOT NULL,
  `type` varchar(4) NOT NULL DEFAULT '转载',
  `desc` varchar(100) NOT NULL,
  `user_id` varchar(64) NOT NULL DEFAULT '0',
  `cate_id` varchar(64) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bloginfo
-- ----------------------------
INSERT INTO `bloginfo` VALUES ('1', '### 项目说明\r\n本项目旨在练习spring boot各知识点的应用，以java后端为主，某些地方可能会显得是为了应用而应用。<br/>\r\n前端要求很低，只是像那么回事就行了，有兴趣学习spring boot的同学可以作为简单的参考。<br/>\r\n同时，本项目尽量做成一个方便本地使用的文件管理系统，包含单不限于博客文章、pdf书籍阅读、资料管理等功能</br>\r\n\r\n### 基础环境说明\r\n>spring boot版本1.5.4<br/>\r\n>java版本1.8<br/>\r\n>maven版本3.2.5<br/>\r\n>使用spring boot结合thymeleaf模板实现页面<br/>\r\n>mysql5.6<br/>\r\n>持久层使用jpa<br/>\r\n\r\n### 涉及的后端具体关键技术点\r\n>jpa操作数据库<br/>\r\n>ServletRequestListener监听器实现访问量的增长<br/>\r\n>spring boot做基本架构<br/>\r\n>spring boot内嵌tomcat服务器<br/>\r\n>thymeleaf模板渲染html填充数据<br/>\r\n>引入showdown.min.js文件实现对markdown语法的支持\r\n\r\n### 基础效果截图如下：\r\n![页面布局截图](images/buju1.png)\r\n\r\n### 历程及已实现功能\r\n**2017-9-26:** 基础页面布局，初次提交到github</br>\r\n**2017-9-28:** 后台基础代码编写和数据库设计</br>\r\n**2017-9-29:** 前端页面增加对markdown语法的支持</br>\r\n\r\n### 预计功能说明\r\n1. 实现类似博客的文章访问功能，如文章标题、内容\r\n1. 实现文章统计功能，如字数、时间、分类\r\n1. 实现pdf书籍阅读功能\r\n1. 实现资料上传和下载、资料列表功能', '数据库文章', '原创', '这个描述三等奖法律手段九分裤螺丝钉就封建时代否三等奖发神经弗兰卡时代峻峰 时代峰峻SD卡否决了时代峻峰', '1', '5', '2020-03-04 09:17:26', '2020-03-04 09:17:37');
INSERT INTO `bloginfo` VALUES ('2', '### 项目说明\r\n本项目旨在练习spring boot各知识点的应用，以java后端为主，某些地方可能会显得是为了应用而应用。<br/>\r\n前端要求很低，只是像那么回事就行了，有兴趣学习spring boot的同学可以作为简单的参考。<br/>\r\n同时，本项目尽量做成一个方便本地使用的文件管理系统，包含单不限于博客文章、pdf书籍阅读、资料管理等功能</br>\r\n\r\n### 基础环境说明\r\n>spring boot版本1.5.4<br/>\r\n>java版本1.8<br/>\r\n>maven版本3.2.5<br/>\r\n>使用spring boot结合thymeleaf模板实现页面<br/>\r\n>mysql5.6<br/>\r\n>持久层使用jpa<br/>\r\n\r\n### 涉及的后端具体关键技术点\r\n>jpa操作数据库<br/>\r\n>ServletRequestListener监听器实现访问量的增长<br/>\r\n>spring boot做基本架构<br/>\r\n>spring boot内嵌tomcat服务器<br/>\r\n>thymeleaf模板渲染html填充数据<br/>\r\n>引入showdown.min.js文件实现对markdown语法的支持\r\n\r\n### 基础效果截图如下：\r\n![页面布局截图](images/buju1.png)\r\n\r\n### 历程及已实现功能\r\n**2017-9-26:** 基础页面布局，初次提交到github</br>\r\n**2017-9-28:** 后台基础代码编写和数据库设计</br>\r\n**2017-9-29:** 前端页面增加对markdown语法的支持</br>\r\n\r\n### 预计功能说明\r\n1. 实现类似博客的文章访问功能，如文章标题、内容\r\n1. 实现文章统计功能，如字数、时间、分类\r\n1. 实现pdf书籍阅读功能\r\n1. 实现资料上传和下载、资料列表功能', '程序人生博客1', '转载', '山东龙口见附录卡萨将东方嘉盛绿壳蛋鸡发生率的否', '2', '1', '2020-03-04 09:17:28', '2020-03-04 09:17:39');
INSERT INTO `bloginfo` VALUES ('3', '### 项目说明\r\n本项目旨在练习spring boot各知识点的应用，以java后端为主，某些地方可能会显得是为了应用而应用。<br/>\r\n前端要求很低，只是像那么回事就行了，有兴趣学习spring boot的同学可以作为简单的参考。<br/>\r\n同时，本项目尽量做成一个方便本地使用的文件管理系统，包含单不限于博客文章、pdf书籍阅读、资料管理等功能</br>\r\n\r\n### 基础环境说明\r\n>spring boot版本1.5.4<br/>\r\n>java版本1.8<br/>\r\n>maven版本3.2.5<br/>\r\n>使用spring boot结合thymeleaf模板实现页面<br/>\r\n>mysql5.6<br/>\r\n>持久层使用jpa<br/>\r\n\r\n### 涉及的后端具体关键技术点\r\n>jpa操作数据库<br/>\r\n>ServletRequestListener监听器实现访问量的增长<br/>\r\n>spring boot做基本架构<br/>\r\n>spring boot内嵌tomcat服务器<br/>\r\n>thymeleaf模板渲染html填充数据<br/>\r\n>引入showdown.min.js文件实现对markdown语法的支持\r\n\r\n### 基础效果截图如下：\r\n![页面布局截图](images/buju1.png)\r\n\r\n### 历程及已实现功能\r\n**2017-9-26:** 基础页面布局，初次提交到github</br>\r\n**2017-9-28:** 后台基础代码编写和数据库设计</br>\r\n**2017-9-29:** 前端页面增加对markdown语法的支持</br>\r\n\r\n### 预计功能说明\r\n1. 实现类似博客的文章访问功能，如文章标题、内容\r\n1. 实现文章统计功能，如字数、时间、分类\r\n1. 实现pdf书籍阅读功能\r\n1. 实现资料上传和下载、资料列表功能', 'java基础111111111', '转载', '栾克军萨菲卡萨卡房间里卡时代峻峰手动阀将山东龙口缴费看历史记录看风景的谁6454非三等奖阿飞就离开撒酒疯肯德基福克斯简单非空将龙宽九段风口浪尖SD卡缴费', '1', '1', '2020-03-04 09:17:31', '2020-03-04 09:17:41');
INSERT INTO `bloginfo` VALUES ('4', '1', '编程语言博客1', '转载', '56465sdfjskldfj克里斯多夫就开始九分裤将山东龙口否决了快睡觉大风 发送队列会计法快睡觉阿卡冷风机昆仑山简单非空静安寺咖啡机', '4', '2', '2020-03-04 09:17:34', '2020-03-04 09:17:44');
INSERT INTO `bloginfo` VALUES ('5', '电饭锅梵蒂冈', '人工智能博客1', '转载', '富商大贾电饭锅第三方地方三方', '3', '3', '2020-03-04 10:32:04', '2020-03-04 10:32:00');
INSERT INTO `bloginfo` VALUES ('6', '似懂非懂谁冈', '这里大数据', '转载', '富商大贾电饭锅第三方水电费第三方三方', '1', '4', '2020-03-04 10:32:04', '2020-03-04 10:32:00');
INSERT INTO `bloginfo` VALUES ('7', '似懂非懂随碟附送费冈', '这里', '转载', '手动阀三方', '2', '6', '2020-03-04 10:32:04', '2020-03-04 10:32:00');
INSERT INTO `bloginfo` VALUES ('8', '似懂非懂谁冈', '这里大数据', '转载', '富商大贾电饭锅第三方水电费第三方三方', '1', '7', '2020-03-04 10:32:04', '2020-03-04 10:32:00');
INSERT INTO `bloginfo` VALUES ('9', '似懂非懂随碟附送费冈', '这里', '转载', '手动放水电费三方', '4', '8', '2020-03-04 10:32:04', '2020-03-04 10:32:00');
INSERT INTO `bloginfo` VALUES ('10', '似懂非懂随碟附送费冈', '这里否', '转载', '手动阀第三方三方', '1', '9', '2020-03-04 10:32:04', '2020-03-04 10:32:00');
INSERT INTO `bloginfo` VALUES ('11', '似懂非懂随碟附送费冈', '这里方法', '转载', '45544三方', '3', '10', '2020-03-04 10:32:04', '2020-03-04 10:32:00');
INSERT INTO `bloginfo` VALUES ('12', '似懂非懂随碟附送费冈', '这里方法手动阀', '转载', 'jjjkj三方', '2', '11', '2020-03-04 10:32:04', '2020-03-04 10:32:00');
INSERT INTO `bloginfo` VALUES ('13', '似懂非懂随碟附送费冈', '这里4', '转载', '发送三方', '1', '12', '2020-03-04 10:32:04', '2020-03-04 10:32:00');
