/*
SQLyog Trial v12.2.1 (64 bit)
MySQL - 5.6.21-log : Database - my_blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`my_blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `my_blog`;

/*Table structure for table `blog_category` */

DROP TABLE IF EXISTS `blog_category`;

CREATE TABLE `blog_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `category_name` varchar(50) DEFAULT '0' COMMENT '类型名称',
  `f_id` int(11) DEFAULT '0' COMMENT '上级id',
  `dict_level` int(5) DEFAULT '1' COMMENT '级别',
  `creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT '1' COMMENT '状态（0停用，1启用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `blog_category` */

insert  into `blog_category`(`id`,`category_name`,`f_id`,`dict_level`,`creat_time`,`status`) values 
(1,'技术博客',0,1,'2018-08-15 11:35:47',1),
(2,'生活杂谈',0,1,'2018-08-15 11:37:10',1),
(3,'资源分享',0,1,'2018-08-15 11:37:48',1),
(4,'JAVA',1,2,'2018-08-15 11:39:02',1),
(5,'数据库',1,2,'2018-08-15 11:38:43',1),
(6,'Linux',1,2,'2018-08-15 11:39:24',1);

/*Table structure for table `blog_treatise` */

DROP TABLE IF EXISTS `blog_treatise`;

CREATE TABLE `blog_treatise` (
  `uuid` varchar(36) NOT NULL,
  `category_id` int(11) DEFAULT NULL COMMENT '种类id',
  `treatise_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `treatise_preview` varchar(2000) DEFAULT NULL COMMENT '预览',
  `source` int(1) DEFAULT NULL COMMENT '由来（1原创，2转载）',
  `reprint_from` varchar(255) DEFAULT NULL COMMENT '来源',
  `reprint_url` varchar(255) DEFAULT NULL COMMENT '来源url',
  `treatise_body` text COMMENT '正文',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `read_num` int(11) DEFAULT NULL COMMENT '阅读量',
  `praise_num` int(11) DEFAULT NULL COMMENT '点赞数',
  `tags` varchar(255) DEFAULT NULL COMMENT '标签'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blog_treatise` */

/*Table structure for table `blog_user` */

DROP TABLE IF EXISTS `blog_user`;

CREATE TABLE `blog_user` (
  `uuid` varchar(36) NOT NULL COMMENT '主键',
  `region_id` varchar(36) DEFAULT NULL COMMENT '地区',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `account` varchar(50) DEFAULT NULL COMMENT '账号',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `describe` varchar(2000) DEFAULT NULL COMMENT '简单描述',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `login_ip` varchar(20) DEFAULT NULL COMMENT '最后登录ip',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `blog_user` */

insert  into `blog_user`(`uuid`,`region_id`,`user_name`,`real_name`,`birthday`,`account`,`password`,`sex`,`email`,`describe`,`create_time`,`login_time`,`login_ip`) values 
('111',NULL,'zhangsan','张三','1993-08-16','zhangsan123',NULL,'男','784727590@qq.com','简单的描述，张三','2018-08-10 14:25:33',NULL,NULL),
('222',NULL,'lisi','李四','1995-01-01','lisi123',NULL,'男','1396848361@qq.com','简单的描述，李四','2018-08-10 14:25:36',NULL,NULL),
('333',NULL,'wangwu','王五','2000-03-10','wangwu123',NULL,'保密','995072611@qq.com','简单的描述，王五','2018-08-10 14:25:37',NULL,NULL),
('578922638baa4aa8879c51a0265161e6','1111','用户名','真名','2018-01-01','yonghuming','password','女','784727590@qq.com','啊是大萨达萨达是','2018-01-05 11:15:15','2018-08-08 18:18:18',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
