rm -f call.log
rm -f tpid
nohup java -jar blog-index-web.jar --spring.config.location=/opt/blog-index-web/conf/application.yml > call.log 2>&1 &
echo $! > tpid
echo Start Success!

