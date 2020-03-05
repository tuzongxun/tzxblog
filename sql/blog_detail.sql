/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : tzxblog

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2020-03-04 19:57:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_detail
-- ----------------------------
DROP TABLE IF EXISTS `blog_detail`;
CREATE TABLE `blog_detail` (
  `id` bigint(64) NOT NULL,
  `blog_id` bigint(64) NOT NULL,
  `fabulous_count` bigint(20) DEFAULT NULL,
  `read_count` bigint(20) DEFAULT NULL,
  `comment_count` bigint(20) DEFAULT NULL,
  `forward_count` bigint(20) DEFAULT NULL,
  `cate_type` varchar(10) DEFAULT NULL COMMENT '热门、公告',
  `power` varchar(10) DEFAULT NULL COMMENT '公开、私有',
  `blog_type` varchar(255) DEFAULT NULL COMMENT '转载、原创',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_detail
-- ----------------------------
INSERT INTO `blog_detail` VALUES ('1', '1', '20', '10000', '23', '5', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('2', '2', '23', '6545', '54', '5', 'recom', null, null);
INSERT INTO `blog_detail` VALUES ('3', '3', '4', '344', '3', '0', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('4', '4', '7', '34', '34', '4', 'hot', null, null);
INSERT INTO `blog_detail` VALUES ('5', '5', '222222', '1555555555', '888888888', '9999999', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('6', '6', '56', '454', '45', '6546', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('7', '7', '0', '23', '0', '0', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('8', '8', '0', '34', '0', '0', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('9', '9', '0', '423', '0', '0', 'recom', null, null);
INSERT INTO `blog_detail` VALUES ('10', '10', '0', '3453', '4', '0', 'recom', null, null);
INSERT INTO `blog_detail` VALUES ('11', '11', '0', '645656', '2334', '454', 'notice', null, null);
INSERT INTO `blog_detail` VALUES ('12', '12', '0', '2344', '345', '0', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('13', '13', '0', '34543', '32', '2', 'hot', null, null);
INSERT INTO `blog_detail` VALUES ('14', '14', '0', '6', '1', '0', 'notice', null, null);
INSERT INTO `blog_detail` VALUES ('15', '15', '0', '56', '0', '0', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('16', '16', '0', '46456', '345', '34', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('17', '17', '0', '34534', '45', '22', 'index', null, null);
INSERT INTO `blog_detail` VALUES ('18', '18', '0', '334', '2', '0', 'notice', null, null);
INSERT INTO `blog_detail` VALUES ('19', '19', '45', '456456', '4445', '54', 'notice', null, null);
