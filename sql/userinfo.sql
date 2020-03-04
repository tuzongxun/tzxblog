/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : tzxblog

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2020-03-04 11:15:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` bigint(20) NOT NULL,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(20) NOT NULL,
  `img` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  UNIQUE KEY `user_account` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('3', 'ttt', '1234', '随风', null, 'sdfsfsd', '33333', null, null);
INSERT INTO `userinfo` VALUES ('1', 'tuzongxun', '123456', '涂宗勋', '15986729975', '1160569243@qq.com', '111111', null, null);
INSERT INTO `userinfo` VALUES ('2', 'tzx', 'tu123456', '我有一个梦', null, '11111', '22222', null, null);
INSERT INTO `userinfo` VALUES ('4', 'tzx123', '123456', '落雁峰', null, 'dsff', '44444', null, null);
