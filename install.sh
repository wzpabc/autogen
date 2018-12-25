#!/bin/bash
# git clone https://wzpabc:1qaz2wsx@gitee.com/wzpabc/bi.git
mvn test -Dtest=com.tupperware.auto.controller.ConfigControllerControllerTest#clear
mvn test -Dtest=com.tupperware.auto.controller.ConfigControllerControllerTest#execute
mvn package -Dmaven.test.skip=true
cd target
ps aux | grep "autogen-1.0.1-RELEASE.jar" |grep -v grep| cut -c 9-15 | xargs kill -9 >/dev/null 2>&1
nohup java -Xmx1024m -jar ./target/autogen-1.0.1-RELEASE.jar  >/dev/null 2>&1 &


