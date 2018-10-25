/*
 Navicat Premium Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost:3306
 Source Schema         : my_blog

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : 65001

 Date: 07/09/2018 18:05:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_about_me
-- ----------------------------
DROP TABLE IF EXISTS `blog_about_me`;
CREATE TABLE `blog_about_me`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `my_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '我的名字',
  `about_me` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '关于我简介',
  `blog_domain_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '博客域名',
  `server_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务器',
  `domain_time` datetime(0) DEFAULT NULL COMMENT '域名创建时间',
  `server_link` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务器链接',
  `record_number` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备案号',
  `program_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '程序',
  `update_time` datetime(0) DEFAULT NULL COMMENT '信息更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关于我' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '类型名称',
  `link_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '跳转url',
  `f_id` int(11) DEFAULT 0 COMMENT '上级id',
  `dict_level` int(5) DEFAULT 1 COMMENT '级别',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT 1 COMMENT '状态（0停用，1启用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES (1, '技术博客', '/knowledge/knowledge.html?categoryId=1', 0, 1, '2018-08-15 11:35:47', 1);
INSERT INTO `blog_category` VALUES (2, '生活杂谈', '/knowledge/knowledge.html?categoryId=2', 0, 1, '2018-08-15 11:37:10', 1);
INSERT INTO `blog_category` VALUES (3, '资源分享', '/knowledge/knowledge.html?categoryId=3', 0, 1, '2018-08-15 11:37:48', 1);
INSERT INTO `blog_category` VALUES (4, '网站介绍', '/common/record-info.html', 0, 1, '2018-09-06 14:24:18', 0);
INSERT INTO `blog_category` VALUES (5, '关于我', '/common/about-me.html', 0, 1, '2018-09-06 14:24:22', 1);
INSERT INTO `blog_category` VALUES (6, '时间轴', '/common/time-axis.html', 0, 1, '2018-09-06 14:24:24', 1);
INSERT INTO `blog_category` VALUES (7, '留言', '/common/gbook.html', 0, 1, '2018-09-06 14:24:27', 1);
INSERT INTO `blog_category` VALUES (10, 'JAVA', '/knowledge/knowledge.html?categoryId=1&thisCategory=10', 1, 2, '2018-08-15 11:39:02', 1);
INSERT INTO `blog_category` VALUES (11, '数据库', '/knowledge/knowledge.html?categoryId=1&thisCategory=11', 1, 2, '2018-08-15 11:38:43', 1);
INSERT INTO `blog_category` VALUES (12, 'Linux', '/knowledge/knowledge.html?categoryId=1&thisCategory=12', 1, 2, '2018-08-15 11:39:24', 1);
INSERT INTO `blog_category` VALUES (13, '网络来源', '/knowledge/knowledge.html?categoryId=2&thisCategory=13', 2, 2, '2018-08-27 10:33:44', 1);
INSERT INTO `blog_category` VALUES (14, '随笔', '/knowledge/knowledge.html?categoryId=2&thisCategory=14', 2, 2, '2018-09-06 14:21:04', 1);
INSERT INTO `blog_category` VALUES (15, '语录', '/knowledge/knowledge.html?categoryId=2&thisCategory=15', 2, 2, '2018-09-06 14:21:06', 1);
INSERT INTO `blog_category` VALUES (16, '有趣资源', '/knowledge/knowledge.html?categoryId=3&thisCategory=16', 3, 2, '2018-10-22 14:58:52', 1);

-- ----------------------------
-- Table structure for blog_friendly_links
-- ----------------------------
DROP TABLE IF EXISTS `blog_friendly_links`;
CREATE TABLE `blog_friendly_links`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接地址',
  `link_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接名称',
  `link_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接标题',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(1) DEFAULT 0 COMMENT '逻辑删除标识（1删除，0正常）',
  `delete_time` datetime(0) DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '友情链接' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for blog_leave_message
-- ----------------------------
DROP TABLE IF EXISTS `blog_leave_message`;
CREATE TABLE `blog_leave_message`  (
  `uuid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ip_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '留言ip地址',
  `fan_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '留言人名称',
  `fan_sex` int(1) DEFAULT 1 COMMENT '性别(1男，2女)',
  `head_img_num` int(3) DEFAULT 1 COMMENT '随机头像码',
  `message_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '留言内容',
  `reply` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复',
  `contact_mail` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系邮箱',
  `create_time` datetime(0) DEFAULT NULL COMMENT '留言时间',
  `status` int(1) DEFAULT 1 COMMENT '状态（1正常，2删除）',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '留言表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `blog_tags`;
CREATE TABLE `blog_tags`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标签名称',
  `category_id` int(11) DEFAULT NULL COMMENT '所属分类',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `click_num` int(11) DEFAULT 0 COMMENT '点击次数',
  `use_num` int(11) DEFAULT 0 COMMENT '使用次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_tags
-- ----------------------------
INSERT INTO `blog_tags` VALUES (1, 'JAVA', 1, '2018-08-20 16:52:29', 0, 0);
INSERT INTO `blog_tags` VALUES (2, 'Linux', 1, '2018-08-20 16:52:29', 0, 0);
INSERT INTO `blog_tags` VALUES (3, 'SVN', 1, '2018-08-20 16:52:29', 0, 0);
INSERT INTO `blog_tags` VALUES (4, 'MySQL', 1, '2018-08-20 16:52:29', 0, 0);

-- ----------------------------
-- Table structure for blog_treatise
-- ----------------------------
DROP TABLE IF EXISTS `blog_treatise`;
CREATE TABLE `blog_treatise`  (
  `uuid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category_id` int(11) DEFAULT NULL COMMENT '种类id',
  `treatise_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `treatise_preview` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '预览',
  `source` int(1) DEFAULT NULL COMMENT '由来（1原创，2转载）',
  `reprint_from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '来源地',
  `reprint_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '来源url',
  `treatise_body` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '正文',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `read_num` int(11) DEFAULT NULL COMMENT '阅读量',
  `praise_num` int(11) DEFAULT NULL COMMENT '点赞数',
  `tags` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标签',
  `recommend` int(1) DEFAULT NULL COMMENT '是否推荐（1是，0否）',
  `del_flag` int(1) DEFAULT '0' COMMENT '逻辑删除标识（1删除，0正常）',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章详情表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user`  (
  `uuid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `region_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地区',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `describe` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简单描述',
  `create_time` datetime(0) DEFAULT NULL COMMENT '注册时间',
  `login_time` datetime(0) DEFAULT NULL COMMENT '最后登录时间',
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后登录ip',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for blog_web_info
-- ----------------------------
DROP TABLE IF EXISTS `blog_web_info`;
CREATE TABLE `blog_web_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `web_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网站简介',
  `web_browse_num` int(11) DEFAULT NULL COMMENT '网站浏览量',
  `web_follow_num` int(11) DEFAULT NULL COMMENT '网站关注量',
  `web_user_num` int(11) DEFAULT NULL COMMENT '网站注册量',
  `update_time` date DEFAULT NULL COMMENT '数据更新时间（按天统计）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '网站的一些统计数据' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for blog_web_technology
-- ----------------------------
DROP TABLE IF EXISTS `blog_web_technology`;
CREATE TABLE `blog_web_technology`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `technology_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '技术标题名称',
  `technology_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '技术内容介绍',
  `show_sort` int(5) DEFAULT NULL COMMENT '显示顺序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关于网站使用的技术' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for blog_admin
-- ----------------------------
DROP TABLE IF EXISTS `blog_admin`;
CREATE TABLE `blog_admin`  (
  `id` int(11) NOT NULL,
  `show_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '显示名称',
  `account` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `status` int(1) DEFAULT 0 COMMENT '状态（1，启用，0，停用）',
  `login_time` datetime(0) DEFAULT NULL COMMENT '最后登录时间',
  `login_ip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后登录ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_admin
-- ----------------------------
INSERT INTO `blog_admin` VALUES (1, '管理员', 'wangAdminBlog', '5c02e66d8f94e824g0a07441971665f0', 1, '2018-09-10 16:16:22', '127.0.0.1');
INSERT INTO `blog_admin` VALUES (2, '写代码测试用户', 'admin', 'dadga249g1c024921edd510g7f359a0c', 0, '2018-10-15 15:52:59', '127.0.0.1');

SET FOREIGN_KEY_CHECKS = 1;
