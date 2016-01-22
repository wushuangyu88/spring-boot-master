/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-01-22 14:38:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for security_user
-- ----------------------------
DROP TABLE IF EXISTS `security_user`;
CREATE TABLE `security_user` (
  `USER_ID` varchar(36) NOT NULL,
  `USER_CODE` varchar(32) DEFAULT NULL,
  `USER_NAME` varchar(32) DEFAULT NULL,
  `USER_PWD` varchar(32) DEFAULT NULL,
  `USER_SEX` varchar(1) DEFAULT NULL,
  `USER_DESC` varchar(128) DEFAULT NULL,
  `USER_STATE` varchar(32) DEFAULT NULL,
  `USER_SORT` int(11) DEFAULT NULL,
  `USER_MAIL` varchar(64) DEFAULT NULL,
  `USER_PHONE` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_user
-- ----------------------------
INSERT INTO `security_user` VALUES ('1', '1', '1', null, null, null, null, null, null, null);
INSERT INTO `security_user` VALUES ('7DE6ED51-3F4B-4BE6-84A6-17BC6186CC24', 'admin', '1113335', '21232F297A57A5A743894A0E4A801FC3', 'M', '内置账户，勿删！！', '1', '1', null, null);
INSERT INTO `security_user` VALUES ('B64DCBC3-F28A-4DC8-92F1-1FB10367CACC', 'user', '默认用户', 'EE11CBB19052E40B07AAC0CA060C23EE', 'M', '默认内置用户，勿删！！', '1', '2', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(36) NOT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `user_desc` varchar(32) DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11', '113', '11', '11');
INSERT INTO `user` VALUES ('22', '22', '22', '22');
