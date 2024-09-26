FROM java:8
MAINTAINER "wangfj"<coder_wangfj@163.com>
ENV APP_VERSION 1.0.0
ENV SPRING_PROFILES_ACTIVE $SPRING_PROFILES_ACTIVE
# 拷贝包到容器，会自动解压
ADD blog-manage-web.tar.gz /app
# 设置工作目录
WORKDIR /app/blog-manage-web
# 启动脚本
ENTRYPOINT ["sh", "/app/blog-manage-web/run.sh", "start"]
EXPOSE 8098

# 构建命令: docker build -f Dockerfile -t blog-manage-web .
# 启动容器: docker run --name=blog-manage-dev -d --env "SPRING_PROFILES_ACTIVE=dev" -p 8088:8088 -p 18086:18086 blog-manage-web
# 启动容器: docker run --name=blog-manage-test -d --env "SPRING_PROFILES_ACTIVE=test" -p 8088:8088 blog-manage-web
