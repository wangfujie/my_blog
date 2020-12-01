FROM java:8
MAINTAINER "wangfj"<784727590@qq.com>
ADD blog-manage-web.jar app.jar
# 指定暴露端口, 这样在容器运行时可以知道应该映射哪些端口
EXPOSE 8098
CMD java -server -Xmx128m -jar app.jar