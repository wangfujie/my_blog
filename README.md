# my_blog
简介：搭建个人博客系统
构建：maven多模块
框架：基于spring-boot
  前台部分：vue+jquery+spring-mvc+mybatis+redis
  后台部分：layui+vue+ueditor+echarts+shiro+spring-mvc+mybatis+redis
  
博客发布状态：
发布1.0版本
    域名：https://blog.wwolf.wang
    发布日期：2018-10-23
    内容：
        前台部分：文章搜索，浏览点赞，分类等，关于我，时间轴，留言功能，友情链接
        后台部分：文章管理增删改，分类管理查询，关于我新增修改，留言查看回复，友情链接增删改
        
更新日志：
    2018-10-25
        前台部分：文章浏览记录，文章点赞记录，网站浏览记录（为了后台统计等）
        后台部分：增加表情管理增删改，百度富文本的图片上传功能，一些打包配置的优化修改等
    2018-12-11
        增加资源分享模块，部分代码
        资源分享目标（实现后台的上传功能，前端实现下载，后期做成前端下载需要登录（QQ登录）才能下载）


nginx配置
```$xml
server {
	listen       80;  #监听端口
	server_name  blog.wwolf.wang;  #监听域名或ip
	charset utf-8;

	location / {
		proxy_pass         http://127.0.0.1:3000;
		proxy_set_header   Host    $host; 
        proxy_set_header   X-Real-IP   $remote_addr; 
        proxy_set_header   X-Forwarded-For $proxy_add_x_forwarded_for;
	}
	
	location /blog {
		proxy_pass         http://127.0.0.1:8088;
		proxy_set_header   Host    $host; 
        proxy_set_header   X-Real-IP   $remote_addr; 
        proxy_set_header   X-Forwarded-For $proxy_add_x_forwarded_for;
	}
}

server {
	listen       80;  #监听端口
	server_name  manage.wwolf.wang;  #监听域名或ip
	charset utf-8;

	location / {
		proxy_pass http://127.0.0.1:8098;
		proxy_set_header   Host    $host; 
        proxy_set_header   X-Real-IP   $remote_addr; 
        proxy_set_header   X-Forwarded-For $proxy_add_x_forwarded_for;
	}
}
```