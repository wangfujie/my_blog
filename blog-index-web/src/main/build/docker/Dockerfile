FROM java:8
MAINTAINER "wangfj"<coder_wangfj@163.com>
# 拷贝包到容器，会自动解压
ADD blog-index-web.tar.gz /app
# 启动脚本
ENTRYPOINT ["sh", "/app/blog-index-web/run.sh", "start"]
EXPOSE 8086
