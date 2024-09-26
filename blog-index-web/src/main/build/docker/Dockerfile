FROM java:8
MAINTAINER "wangfj"<coder_wangfj@163.com>
ENV APP_VERSION 1.0.0
ENV SPRING_PROFILES_ACTIVE $SPRING_PROFILES_ACTIVE
# 拷贝包到容器，会自动解压
ADD blog-index-web.tar.gz /app
# 启动脚本
ENTRYPOINT ["sh", "/app/blog-index-web/run.sh", "start"]
EXPOSE 8086

# 构建命令: docker build -t blog-index-web .
