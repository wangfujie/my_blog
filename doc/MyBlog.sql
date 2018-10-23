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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关于我' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_about_me
-- ----------------------------
INSERT INTO `blog_about_me` VALUES (1, 'Mr王', '这个人很神秘，什么都没有描述！', 'http://127.0.0.1:8088/', '阿里服务器', '2018-09-06 17:21:12', 'https://www.aliyun.com', '无', 'JAVA', '2018-09-06 17:21:32');

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
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES (1, '技术博客', 'knowledge/knowledge.html?categoryId=1', 0, 1, '2018-08-15 11:35:47', 1);
INSERT INTO `blog_category` VALUES (2, '生活杂谈', 'knowledge/knowledge.html?categoryId=2', 0, 1, '2018-08-15 11:37:10', 1);
INSERT INTO `blog_category` VALUES (3, '资源分享', 'knowledge/knowledge.html?categoryId=3', 0, 1, '2018-08-15 11:37:48', 1);
INSERT INTO `blog_category` VALUES (4, '网站介绍', 'common/web-info.html', 0, 1, '2018-09-06 14:24:18', 0);
INSERT INTO `blog_category` VALUES (5, '关于我', 'common/about-me.html', 0, 1, '2018-09-06 14:24:22', 1);
INSERT INTO `blog_category` VALUES (6, '时间轴', 'common/time-axis.html', 0, 1, '2018-09-06 14:24:24', 1);
INSERT INTO `blog_category` VALUES (7, '留言', 'common/gbook.html', 0, 1, '2018-09-06 14:24:27', 1);
INSERT INTO `blog_category` VALUES (10, 'JAVA', 'knowledge/knowledge.html?categoryId=1&thisCategory=10', 1, 2, '2018-08-15 11:39:02', 1);
INSERT INTO `blog_category` VALUES (11, '数据库', 'knowledge/knowledge.html?categoryId=1&thisCategory=11', 1, 2, '2018-08-15 11:38:43', 1);
INSERT INTO `blog_category` VALUES (12, 'Linux', 'knowledge/knowledge.html?categoryId=1&thisCategory=12', 1, 2, '2018-08-15 11:39:24', 1);
INSERT INTO `blog_category` VALUES (13, '网络来源', 'knowledge/knowledge.html?categoryId=2&thisCategory=13', 2, 2, '2018-08-27 10:33:44', 1);
INSERT INTO `blog_category` VALUES (14, '随笔', 'knowledge/knowledge.html?categoryId=2&thisCategory=14', 2, 2, '2018-09-06 14:21:04', 1);
INSERT INTO `blog_category` VALUES (15, '语录', 'knowledge/knowledge.html?categoryId=2&thisCategory=15', 2, 2, '2018-09-06 14:21:06', 1);
INSERT INTO `blog_category` VALUES (16, '有趣资源', 'knowledge/knowledge.html?categoryId=3&thisCategory=16', 3, 2, '2018-10-22 14:58:52', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '友情链接' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_friendly_links
-- ----------------------------
INSERT INTO `blog_friendly_links` VALUES (1, 'https://www.baidu.com/', '链接1', '链接1', '2018-08-20 16:03:07', 0, NULL);
INSERT INTO `blog_friendly_links` VALUES (2, 'https://www.baidu.com/', '链接2', '链接2', '2018-08-20 16:03:09', 0, NULL);
INSERT INTO `blog_friendly_links` VALUES (3, 'https://www.baidu.com/', '链接3', '链接3', '2018-08-20 16:03:10', 0, NULL);

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
-- Records of blog_leave_message
-- ----------------------------
INSERT INTO `blog_leave_message` VALUES ('1111', '127.0.0.1', '张三', 1, 1, '撒大苏打实打实的', '撒大苏打', NULL, '2018-09-07 10:49:31', 1);
INSERT INTO `blog_leave_message` VALUES ('19833c6f3c904de9b22159030f839676', NULL, '打法的说法', 1, 14, '发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶', '大师傅似的手动阀', 'sadsad@qq.com', '2018-09-07 17:15:52', 1);
INSERT INTO `blog_leave_message` VALUES ('20fb84a2728b4b27824d93da2faa69e4', NULL, '的v啊', 1, 11, '大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀大师傅似的手动阀', NULL, 'sadsad@qq.com', '2018-09-07 17:17:06', 1);
INSERT INTO `blog_leave_message` VALUES ('2222', '127.0.0.1', '历史', 2, 16, 'dfzvfgrsgrfgsg发噶地方的法国队', '大师傅似的手动阀', NULL, '2018-09-07 10:49:55', 1);
INSERT INTO `blog_leave_message` VALUES ('32c8a94d70c44afa8b131c2c92b5608f', NULL, '手动阀十分', 1, 13, '发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶', '大师傅似的手动阀', 'sadsad@qq.com', '2018-09-07 17:15:39', 1);
INSERT INTO `blog_leave_message` VALUES ('3333', '127.0.0.1', '撒旦撒', 1, 2, '大发噶时光色发电公司梵蒂冈', '大师傅似的手动阀', NULL, '2018-09-07 10:50:21', 1);
INSERT INTO `blog_leave_message` VALUES ('397513f543214172b4b003cf3af41f16', NULL, '1', 1, 13, NULL, '大师傅似的手动阀', NULL, '2018-09-07 16:03:27', 1);
INSERT INTO `blog_leave_message` VALUES ('42a0684707044c3f9a91b72e74d9cb52', NULL, '的说法', 1, 16, '的说法是放大范德萨的说法是放大范德萨的说法是放大范德萨的说法是放大范德萨的说法是放大范德萨', '大师傅似的手动阀', 'sadsad@qq.com', '2018-09-07 17:10:44', 1);
INSERT INTO `blog_leave_message` VALUES ('4444', NULL, '撒打算', 1, 6, '大发噶时光色发电公司梵蒂冈', '撒旦撒', NULL, '2018-09-07 10:50:21', 1);
INSERT INTO `blog_leave_message` VALUES ('5008d143fc0345aa8a58cc8f799b9ddc', NULL, 'a', 1, 13, 'fadsfda', '大师傅似的手动阀', 'dsda@qq.com', '2018-09-07 16:40:53', 1);
INSERT INTO `blog_leave_message` VALUES ('5555', NULL, '地方', 2, 12, '大发噶时光色发电公司梵蒂冈', '大师傅似的手动阀', NULL, '2018-09-07 10:50:21', 1);
INSERT INTO `blog_leave_message` VALUES ('6666', NULL, '对方的', 1, 15, '大发噶时光色发电公司梵蒂冈', '士大夫s', NULL, '2018-09-07 10:50:21', 1);
INSERT INTO `blog_leave_message` VALUES ('8fc979e8cae74981907208784a0af7a1', NULL, '发到', 1, 6, '的撒旦发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶发的噶', '大师傅似的手动阀', 'sadsad@qq.com', '2018-09-07 17:16:05', 1);
INSERT INTO `blog_leave_message` VALUES ('98a66fd42ae640eaaf6fa5ae092b75f4', NULL, NULL, 1, 7, NULL, '大师傅似的手动阀', NULL, '2018-09-07 16:00:19', 0);
INSERT INTO `blog_leave_message` VALUES ('acf25f7462fb4bcdbde69fe8755dfeb4', NULL, '撒旦撒23', 1, 12, '撒大苏打撒旦撒撒大苏打撒旦撒撒大苏打撒旦撒撒大苏打撒旦撒撒大苏打撒旦撒撒大苏打撒旦撒撒大苏打撒旦撒\n撒旦发生方式', '大师傅似的手动阀', 'sadsad@qq.com', '2018-09-07 17:14:45', 1);
INSERT INTO `blog_leave_message` VALUES ('b47703f0373b412ba940505dae0c9c3d', NULL, '12312', 1, 4, 'sadasdas', '大师傅似的手动阀', 'sadds@qq.com', '2018-09-07 17:02:24', 1);
INSERT INTO `blog_leave_message` VALUES ('ca7b5605e06340dd8fbe5159280519b4', NULL, '1', 1, 12, '3333333333333333333', '大师傅似的手动阀', '2', '2018-09-07 15:17:21', 1);
INSERT INTO `blog_leave_message` VALUES ('e3ea2f4c207d4aa0b04cd5b9ac9e0d17', NULL, 'ss', 1, 4, NULL, '大师傅似的手动阀', NULL, '2018-09-07 16:04:40', 1);

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
INSERT INTO `blog_tags` VALUES (1, 'JAVA', 4, '2018-08-20 16:52:29', 0, 5);
INSERT INTO `blog_tags` VALUES (2, 'Linux', 6, '2018-08-20 16:52:29', 0, 3);
INSERT INTO `blog_tags` VALUES (3, 'SVN', 1, '2018-08-20 16:52:29', 0, 2);
INSERT INTO `blog_tags` VALUES (4, 'MySQL', 5, '2018-08-20 16:52:29', 0, 4);
INSERT INTO `blog_tags` VALUES (5, 'Jenkins', 1, '2018-08-20 16:53:59', 0, 1);

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
-- Records of blog_treatise
-- ----------------------------
INSERT INTO `blog_treatise` VALUES ('1111111', 10, 'Java Pattern和Matcher详解 [转载]', '最近玩了玩微信公众号开发之后，想写一个爬虫为公众号爬一点数据；在测试过程中，需要获取页面的所有链接，比较快捷的办法是使用正则表达式直接匹配，那么Java中的字符串正则用的是Pattern和Matcher结合，功能还是蛮强大的；我平时工作中对这两个类接触的少，具体的使用这篇博文写的很详细，转载记录一下；', 2, NULL, 'http://blog.csdn.net/cclovett/article/details/12448843/', 'Java代码示例:\r\n\r\nPattern p=Pattern.compile(\"\\\\w+\"); \r\np.pattern();//返回 \\w+ \r\n\r\npattern() 返回正则表达式的字符串形式,其实就是返回Pattern.complile(String regex)的regex参数 \r\n1.Pattern.split(CharSequence input)\r\nPattern有一个split(CharSequence input)方法,用于分隔字符串,并返回一个String[],我猜String.split(String regex)就是通过Pattern.split(CharSequence input)来实现的.\r\n\r\nJava代码示例:\r\n\r\nPattern p=Pattern.compile(\"\\\\d+\"); \r\nString[] str=p.split(\"我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com\"); \r\n\r\n结果:str[0]=\"我的QQ是:\" str[1]=\"我的电话是:\" str[2]=\"我的邮箱是:aaa@aaa.com\" \r\n2.Pattern.matches(String regex,CharSequence input)\r\n一个静态方法,用于快速匹配字符串,该方法适合用于只匹配一次,且匹配全部字符串.\r\n\r\nJava代码示例:\r\n\r\nPattern.matches(\"\\\\d+\",\"2223\");\r\n//返回true \r\nPattern.matches(\"\\\\d+\",\"2223aa\");\r\n//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到 \r\nPattern.matches(\"\\\\d+\",\"22bb23\");\r\n//返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到 \r\n3.Pattern.matcher(CharSequence input)\r\n说了这么多,终于轮到Matcher类登场了,Pattern.matcher(CharSequence input)返回一个Matcher对象.\r\n\r\nMatcher类的构造方法也是私有的,不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.\r\n\r\nPattern类只能做一些简单的匹配操作,要想得到更强更便捷的正则匹配操作,那就需要将Pattern与Matcher一起合作.Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持.\r\n\r\nJava代码示例:\r\n\r\nPattern p=Pattern.compile(\"\\\\d+\"); \r\nMatcher m=p.matcher(\"22bb23\"); \r\nm.pattern();//返回p 也就是返回该Matcher对象是由哪个Pattern对象的创建的 \r\n4.Matcher.matches() / Matcher.lookingAt() / Matcher.find()\r\nMatcher类提供三个匹配操作方法,三个方法均返回boolean类型,当匹配到时返回true,没匹配到则返回false\r\n\r\nmatches()对整个字符串进行匹配,只有整个字符串都匹配了才返回true\r\nJava代码示例:\r\n\r\nPattern p=Pattern.compile(\"\\\\d+\"); \r\nMatcher m=p.matcher(\"22bb23\"); \r\nm.matches(); //返回false,因为bb不能被\\d+匹配,导致整个字符串匹配未成功. \r\nMatcher m2=p.matcher(\"2223\"); \r\nm2.matches(); //返回true,因为\\d+匹配到了整个字符串 \r\n我们现在回头看一下Pattern.matches(String regex,CharSequence input),它与下面这段代码等价 Pattern.compile(regex).matcher(input).matches()\r\n\r\nlookingAt()对前面的字符串进行匹配,只有匹配到的字符串在最前面才返回true\r\nJava代码示例:\r\n\r\nPattern p=Pattern.compile(\"\\\\d+\"); \r\nMatcher m=p.matcher(\"22bb23\");\r\nm.lookingAt(); //返回true,因为\\d+匹配到了前面的22\r\nMatcher m2=p.matcher(\"aa2223\");\r\nm2.lookingAt(); //返回false,因为\\d+不能匹配前面的aa\r\nfind()对字符串进行匹配,匹配到的字符串可以在任何位置.\r\nJava代码示例:\r\n\r\nPattern p=Pattern.compile(\"\\\\d+\"); \r\nMatcher m=p.matcher(\"22bb23\"); \r\nm.find(); //返回true \r\nMatcher m2=p.matcher(\"aa2223\"); \r\nm2.find(); //返回true \r\nMatcher m3=p.matcher(\"aa2223bb\"); \r\nm3.find(); //返回true \r\nMatcher m4=p.matcher(\"aabb\"); \r\nm4.find(); //返回false \r\n5.Mathcer.start() / Matcher.end() / Matcher.group()\r\n当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以上三个方法得到更详细的信息.\r\n\r\nstart()返回匹配到的子字符串在字符串中的索引位置.\r\nend()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.\r\ngroup()返回匹配到的子字符串\r\n\r\nJava代码示例:\r\n\r\nPattern p=Pattern.compile(\"\\\\d+\"); \r\nMatcher m=p.matcher(\"aaa2223bb\"); \r\nm.find();//匹配2223 \r\nm.start();//返回3 \r\nm.end();//返回7,返回的是2223后的索引号 \r\nm.group();//返回2223 \r\n\r\nMathcer m2=p.matcher(\"2223bb\"); \r\nm2.lookingAt();   //匹配2223 \r\nm2.start();   //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0 \r\nm2.end();   //返回4 \r\nm2.group();   //返回2223 \r\n\r\nMatcher m3=p.matcher(\"2223\"); //如果Matcher m3=p.matcher(\"2223bb\"); 那么下面的方法出错，因为不匹配返回false\r\nm3.matches();   //匹配整个字符串 \r\nm3.start();   //返回0\r\nm3.end();   //返回3,原因相信大家也清楚了,因为matches()需要匹配所有字符串 \r\nm3.group();   //返回2223\r\n说了这么多,相信大家都明白了以上几个方法的使用,该说说正则表达式的分组在java中是怎么使用的.\r\nstart(),end(),group()均有一个重载方法它们是start(int i),end(int i),group(int i)专用于分组操作,Mathcer类还有一个groupCount()用于返回有多少组.\r\n\r\nJava代码示例:\r\n\r\nPattern p=Pattern.compile(\"([a-z]+)(\\\\d+)\"); \r\nMatcher m=p.matcher(\"aaa2223bb\"); \r\nm.find();   //匹配aaa2223 \r\nm.groupCount();   //返回2,因为有2组 \r\nm.start(1);   //返回0 返回第一组匹配到的子字符串在字符串中的索引号 \r\nm.start(2);   //返回3 \r\nm.end(1);   //返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置. \r\nm.end(2);   //返回7 \r\nm.group(1);   //返回aaa,返回第一组匹配到的子字符串 \r\nm.group(2);   //返回2223,返回第二组匹配到的子字符串 \r\n现在我们使用一下稍微高级点的正则匹配操作,例如有一段文本,里面有很多数字,而且这些数字是分开的,我们现在要将文本中所有数字都取出来,利用java的正则操作是那么的简单.\r\n\r\nJava代码示例:\r\n\r\nPattern p=Pattern.compile(\"\\\\d+\"); \r\nMatcher m=p.matcher(\"我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com\"); \r\nwhile(m.find()) { \r\n     System.out.println(m.group()); \r\n} \r\n\r\n输出: \r\n456456 \r\n0532214 \r\n123 \r\n如将以上while()循环替换成\r\n\r\nwhile(m.find()) { \r\n     System.out.println(m.group()); \r\n     System.out.print(\"start:\"+m.start()); \r\n     System.out.println(\" end:\"+m.end()); \r\n} \r\n\r\n则输出: \r\n456456 \r\nstart:6 end:12 \r\n0532214 \r\nstart:19 end:26 \r\n123 \r\nstart:36 end:39 \r\n现在大家应该知道,每次执行匹配操作后start(),end(),group()三个方法的值都会改变,改变成匹配到的子字符串的信息,以及它们的重载方法,也会改变成相应的信息.\r\n\r\n注意:只有当匹配操作成功,才可以使用start(),end(),group()三个方法,否则会抛出java.lang.IllegalStateException,也就是当matches(),lookingAt(),find()其中任意一个方法返回true时,才可以使用.', '2018-08-16 10:29:18', 10, 1, 'JAVA,编程', 1);
INSERT INTO `blog_treatise` VALUES ('21312312', 12, '收费的各色', '热告诉他日后德德德德德是他', 1, NULL, NULL, '正文', '2018-09-05 15:39:31', 0, 0, NULL, NULL);
INSERT INTO `blog_treatise` VALUES ('dsfasfWD', 11, '热天气二', '热告诉他日后若是他热告诉他日后若是他', 1, NULL, NULL, '正文', '2018-09-05 15:39:31', 0, 0, NULL, NULL);
INSERT INTO `blog_treatise` VALUES ('FWEWEWEW', 10, 'retreat', '热德德德告诉他日后若德德德德是他德德德德', 1, NULL, NULL, '正文', '2018-09-05 15:39:31', 0, 0, NULL, NULL);
INSERT INTO `blog_treatise` VALUES ('sadasdasdaa', 11, '二位太热', '热告诉他日德德德德德若是他', 1, NULL, NULL, '正文', '2018-09-05 15:39:31', 0, 0, NULL, NULL);
INSERT INTO `blog_treatise` VALUES ('sadsadsa', 10, '了我突然图为率', '热告诉他日后德德德若是他德德德', 1, NULL, NULL, '正文', '2018-09-05 15:39:31', 0, 0, NULL, NULL);
INSERT INTO `blog_treatise` VALUES ('sdas21d', 12, '测试标题', '的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分', 1, NULL, '', '的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分的撒发范德萨分', '2018-09-05 15:16:21', 0, 0, NULL, 1);
INSERT INTO `blog_treatise` VALUES ('SSADESA', 10, '都是手工散热', '热告诉他日后若是他热告诉他日后若是他热告诉他日后若是他热告诉他日后若是他', 1, NULL, NULL, '正文', '2018-09-05 15:39:31', 0, 0, NULL, NULL);

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `web_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网站简介',
  `web_browse_num` int(11) DEFAULT NULL COMMENT '网站浏览量',
  `web_follow_num` int(11) DEFAULT NULL COMMENT '网站关注量',
  `web_user_num` int(11) DEFAULT NULL COMMENT '网站注册量',
  `update_time` date DEFAULT NULL COMMENT '数据更新时间（按天统计）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '网站的一些统计数据' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_web_info
-- ----------------------------
INSERT INTO `blog_web_info` VALUES (1, '简介', 0, 0, 0, '2018-08-15');

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
INSERT INTO `blog_admin` VALUES (2, '写代码测试用户', 'admin', 'dadga249g1c024921edd510g7f359a0c', 1, '2018-10-15 15:52:59', '127.0.0.1');

SET FOREIGN_KEY_CHECKS = 1;
