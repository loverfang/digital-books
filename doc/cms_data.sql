/*
Navicat MySQL Data Transfer

Source Server         : 18
Source Server Version : 50729
Source Host           : 192.168.89.18:3306
Source Database       : wx

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-08-29 16:50:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cms_data
-- ----------------------------
DROP TABLE IF EXISTS `cms_data`;
CREATE TABLE `cms_data` (
  `data_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `abstracts` varchar(1000) DEFAULT NULL,
  `content` longtext,
  `cover_img_url` varchar(500) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `platform` varchar(100) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL,
  `down_count` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_data
-- ----------------------------

-- ----------------------------
-- Table structure for cms_data_file
-- ----------------------------
DROP TABLE IF EXISTS `cms_data_file`;
CREATE TABLE `cms_data_file` (
  `file_id` bigint(20) NOT NULL,
  `data_id` bigint(20) NOT NULL,
  `file_name` varchar(500) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `file_path` varchar(500) DEFAULT NULL,
  `file_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_data_file
-- ----------------------------
