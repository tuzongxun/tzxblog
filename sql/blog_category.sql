/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : tzxblog

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2020-03-03 15:03:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` bigint(64) NOT NULL,
  `name` varchar(25) NOT NULL,
  `desc` varchar(225) DEFAULT NULL,
  `order` int(5) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES ('1', '程序人生', '职场经验和潜规则', '997', '2020-03-03 12:36:12', '2020-03-03 12:36:15');
INSERT INTO `blog_category` VALUES ('2', '编程语言', 'java、c、vue等', '999', '2020-03-03 12:53:34', '2020-03-03 12:53:37');
INSERT INTO `blog_category` VALUES ('3', '人工智能', null, '998', '2020-03-03 12:54:08', '2020-03-03 12:54:11');
INSERT INTO `blog_category` VALUES ('4', '大数据', null, '0', '2020-03-03 12:54:24', '2020-03-03 12:54:27');
INSERT INTO `blog_category` VALUES ('5', '数据库', null, '0', '2020-03-03 12:54:38', '2020-03-03 12:54:41');
INSERT INTO `blog_category` VALUES ('6', '移动开发', null, '995', '2020-03-03 12:54:49', '2020-03-03 12:54:52');
INSERT INTO `blog_category` VALUES ('7', '运维', null, '0', '2020-03-03 12:55:02', '2020-03-03 12:55:05');
INSERT INTO `blog_category` VALUES ('8', '硬件', null, '0', '2020-03-03 12:55:15', '2020-03-03 12:55:18');
INSERT INTO `blog_category` VALUES ('9', '算法', null, '0', '2020-03-03 12:55:26', '2020-03-03 12:55:29');
INSERT INTO `blog_category` VALUES ('10', '操作系统', null, '0', '2020-03-03 12:55:48', '2020-03-03 12:55:51');
INSERT INTO `blog_category` VALUES ('11', '网络协议', null, '0', '2020-03-03 12:56:01', '2020-03-03 12:56:03');
INSERT INTO `blog_category` VALUES ('12', '物联网', null, '996', '2020-03-03 12:56:11', '2020-03-03 12:56:15');
