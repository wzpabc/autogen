#!/bin/bash
#git clone https://github.com/wzpabc/autogen.git
#cd autogen
mysql -h192.168.10.175 -uroot -p12345 it < ./src/main/resources/sql/mysql_config_controller.sql
mvn clean
mvn test -Dtest=com.tupperware.auto.controller.ConfigControllerControllerTest#clear
mvn test -Dtest=com.tupperware.auto.controller.ConfigControllerControllerTest#execute
sleep 5
mvn clean
mvn package -Dmaven.test.skip=true
ps aux | grep "autogen-1.0.1-RELEASE.jar" |grep -v grep| cut -c 9-15 | xargs kill -9 >/dev/null 2>&1
echo killing
sleep 5
nohup java -Xmx1024m -jar ./target/autogen-1.0.1-RELEASE.jar  >/dev/null 2>&1 &
echo start


