-- 升级脚本2.0

-- ----------------------------
-- 增加日志记录
-- ----------------------------
DROP TABLE IF EXISTS `blog_log_record`;
CREATE TABLE `blog_log_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `record_type` varchar(255) DEFAULT NULL COMMENT '记录类别（1、点赞文章，2、阅读文章，3、主页浏览）',
  `treatise_uuid` varchar(50) DEFAULT NULL COMMENT '对应的文章',
  `ip_address` varchar(50) DEFAULT NULL COMMENT '记录ip地址',
  `create_time` datetime DEFAULT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='日志记录';
