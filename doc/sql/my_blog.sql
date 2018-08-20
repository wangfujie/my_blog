/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : my_blog

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 15/08/2018 23:23:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_about_me
-- ----------------------------
DROP TABLE IF EXISTS `blog_about_me`;
CREATE TABLE `blog_about_me`  (
  `id` int(11) NOT NULL,
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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关于我' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '类型名称',
  `f_id` int(11) DEFAULT 0 COMMENT '上级id',
  `dict_level` int(5) DEFAULT 1 COMMENT '级别',
  `creat_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT 1 COMMENT '状态（0停用，1启用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES (1, '技术博客', 0, 1, '2018-08-15 11:35:47', 1);
INSERT INTO `blog_category` VALUES (2, '生活杂谈', 0, 1, '2018-08-15 11:37:10', 1);
INSERT INTO `blog_category` VALUES (3, '资源分享', 0, 1, '2018-08-15 11:37:48', 1);
INSERT INTO `blog_category` VALUES (4, 'JAVA', 1, 2, '2018-08-15 11:39:02', 1);
INSERT INTO `blog_category` VALUES (5, '数据库', 1, 2, '2018-08-15 11:38:43', 1);
INSERT INTO `blog_category` VALUES (6, 'Linux', 1, 2, '2018-08-15 11:39:24', 1);

-- ----------------------------
-- Table structure for blog_leave_message
-- ----------------------------
DROP TABLE IF EXISTS `blog_leave_message`;
CREATE TABLE `blog_leave_message`  (
  `uuid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ip_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '留言ip地址',
  `fan_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '留言人名称',
  `fan_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `contact_mail` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系邮箱',
  `create_time` datetime(0) DEFAULT NULL COMMENT '留言时间',
  `status` int(1) DEFAULT 1 COMMENT '状态（1正常，2删除）',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '留言表' ROW_FORMAT = Dynamic;

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
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文章详情表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES ('111', NULL, 'zhangsan', '张三', '1993-08-16', 'zhangsan123', NULL, '男', '784727590@qq.com', '简单的描述，张三', '2018-08-10 14:25:33', NULL, NULL);
INSERT INTO `blog_user` VALUES ('222', NULL, 'lisi', '李四', '1995-01-01', 'lisi123', NULL, '男', '1396848361@qq.com', '简单的描述，李四', '2018-08-10 14:25:36', NULL, NULL);
INSERT INTO `blog_user` VALUES ('333', NULL, 'wangwu', '王五', '2000-03-10', 'wangwu123', NULL, '保密', '995072611@qq.com', '简单的描述，王五', '2018-08-10 14:25:37', NULL, NULL);
INSERT INTO `blog_user` VALUES ('578922638baa4aa8879c51a0265161e6', '1111', '用户名', '真名', '2018-01-01', 'yonghuming', 'password', '女', '784727590@qq.com', '啊是大萨达萨达是', '2018-01-05 11:15:15', '2018-08-08 18:18:18', NULL);

-- ----------------------------
-- Table structure for blog_web_info
-- ----------------------------
DROP TABLE IF EXISTS `blog_web_info`;
CREATE TABLE `blog_web_info`  (
  `id` int(11) NOT NULL,
  `web_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网站简介',
  `web_browse_num` int(11) DEFAULT NULL COMMENT '网站浏览量',
  `web_follow_num` int(11) DEFAULT NULL COMMENT '网站关注量',
  `web_user_num` int(11) DEFAULT NULL COMMENT '网站注册量',
  `update_time` date DEFAULT NULL COMMENT '数据更新时间（按天统计）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '网站的一些统计数据' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_web_info
-- ----------------------------
INSERT INTO `blog_web_info` VALUES (1, '简介', 0, 0, 0, '2018-08-15');

-- ----------------------------
-- Table structure for blog_web_technology
-- ----------------------------
DROP TABLE IF EXISTS `blog_web_technology`;
CREATE TABLE `blog_web_technology`  (
  `id` int(11) NOT NULL,
  `technology_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '技术标题名称',
  `technology_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '技术内容介绍',
  `show_sort` int(5) DEFAULT NULL COMMENT '显示顺序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关于网站使用的技术' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `blog_friendly_links`;
CREATE TABLE `blog_friendly_links` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link_url` varchar(200) DEFAULT NULL COMMENT '链接地址',
  `link_name` varchar(50) DEFAULT NULL COMMENT '链接名称',
  `link_title` varchar(50) DEFAULT NULL COMMENT '链接标题',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `del_falg` int(1) DEFAULT '0' COMMENT '逻辑删除标识',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='友情链接';

DROP TABLE IF EXISTS `blog_tags`;
CREATE TABLE `blog_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) DEFAULT NULL COMMENT '标签名称',
  `category_id` int(11) DEFAULT NULL COMMENT '所属分类',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';


SET FOREIGN_KEY_CHECKS = 1;
