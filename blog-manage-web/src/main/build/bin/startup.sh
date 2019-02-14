#!/usr/bin/env bash
rm -f call.log
rm -f tpid
nohup java -jar blog-manage-web.jar --spring.config.location=/opt/blog-manage-web/application.properties > call.log 2>&1 &
echo $! > tpid
echo Start Success!

