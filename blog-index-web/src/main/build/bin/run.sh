#!/bin/bash
#author:wangfj

#获取项目运行目录
workdir=$(pwd)

#jvm参数配置
jvm="-server -Xmx1024m -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"

#项目jar包文件
app_name=blog-index-web.jar

#项目配置文件类型(properties|yml)
config_type=yml

#项目配置文件
config_file="-Dspring.config.location=${workdir}/application.${config_type}"

#日志记录文件
log_file=out.log

#pid记录文件
pid_file=pid.txt

#使用说明,用来提示输入参数
usage(){
	echo "提示: 运行此脚本请带上下列参数之一[start|stop|restart|status]，比如启动项目运行命令：./run.sh start"
	exit 1
}

#检查程序是否在运行
is_exist(){
	pid=`ps -ef|grep ${app_name}|grep -v grep|awk '{print $2}'`
	#如果不存在返回1,存在返回0
	if [ -z "${pid}" ]; then
		return 1
	else
		return 0
	fi
}

#启动方法
start(){
	is_exist
	if [ $? -eq "0" ]; then
		echo "${app_name} is already running,pid is ${pid}"
	else
		rm -f ${log_file}
		rm -f ${pid_file}
		#后台运行jar包并记录日志
		nohup java ${jvm} -jar ${config_file} ${app_name} > ${log_file} 2>&1 &
		#记录pid
		echo $! > ${pid_file}
		echo "${app_name} is start success,pid is $!"
	fi
}

#停止方法
stop(){
	is_exist
	if [ $? -eq "0" ]; then
		kill -9 ${pid}
	else
		echo "${app_name} is not running"
	fi
}

#运行状态
status(){
	is_exist
	if [ $? -eq "0" ]; then
		echo "${app_name} is running,pid is ${pid}"
	else
		echo "${app_name} is not running"
	fi
}

#重启方法
restart(){
	stop
	sleep 5
	start
}
 
#根据输入参数,选择执行对应方法,不输入则执行使用说明
case "$1" in
	"start") start;;
	"stop") stop;;
	"status") status;;
	"restart") restart;;
	*) usage;;
esac
