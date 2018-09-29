#!/bin/bash
cd /opt/tup
rm -rvf ./bi
git clone https://wzpabc:1qaz2wsx@gitee.com/wzpabc/bi.git
chmod -R 777 ./bi
cd bi/bi-sqlparser/
mvn package -Dmaven.test.skip=true
cd target
ps aux | grep "bi-sqlparser-1.0.1-RELEASE.jar" |grep -v grep| cut -c 9-15 | xargs kill -9 >/dev/null 2>&1
nohup java -Xmx1024m -jar bi-sqlparser-1.0.1-RELEASE.jar >/dev/null 2>&1 &


