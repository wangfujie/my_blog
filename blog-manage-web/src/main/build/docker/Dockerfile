FROM java:8
MAINTAINER "wangfj"<coder_wangfj@163.com>
# 拷贝包到容器，会自动解压
ADD blog-manage-web.tar.gz /app
# 启动脚本
ENTRYPOINT ["sh", "/app/blog-manage-web/run.sh", "start"]
EXPOSE 8098
