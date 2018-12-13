-- 升级脚本2.1

-- ----------------------------
-- 增加资源分享信息表
-- ----------------------------
CREATE TABLE `blog_resource_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `resource_name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `resource_desc` varchar(200) DEFAULT NULL COMMENT '资源描述',
	`resource_level` varchar(200) COMMENT '资源等级',
	`category_id` int(11) COMMENT '对应分类id',
  `tags` varchar(200) COMMENT '资源标签',
	`file_id` int(11) COMMENT '对应的文件id',
	`last_update_time` datetime DEFAULT NULL COMMENT '最近修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT '1' COMMENT '是否开启分享（0不开启，1开启）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='资源分享信息表';

-- ----------------------------
-- 增加文件信息表
-- ----------------------------
CREATE TABLE `blog_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`file_name` varchar(200) DEFAULT NULL COMMENT '文件名',
  `file_path` varchar(200) DEFAULT NULL COMMENT '文件路径',
  `file_type` varchar(50) COMMENT '文件类型(扩展名)',
	`file_size` varchar(50) DEFAULT NULL COMMENT '文件大小',
	`description` varchar(100) DEFAULT NULL COMMENT '文件描述',
	`short_path` varchar(200) DEFAULT NULL COMMENT '短路径',
	`file_uuid` varchar(100) DEFAULT NULL COMMENT '文件uuid',
  `create_time` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文件信息表';