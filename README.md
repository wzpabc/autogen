# autogen
### first crete database in mysql 
* create database gen_mysql
#### import sql script into gen_mysql
* step 0 

`generate mysql_config_controller.sql`
* step 1. 

`mysql -uroot -proot gen_mysql < mysql_config_controller.sql
`

* step 2 .

`mvn test -Dtest=com.tupperware.auto.controller.ConfigControllerControllerTest#clear`  

`mvn test -Dtest=com.tupperware.auto.controller.ConfigControllerControllerTest#execute`  


* step 3 .

`mvn test -Dtest=com.tupperware.auto.controller.ConfigControllerControllerTest#testFormatSql`  

* step 4 package .

`mvn package -D maven.test.skip=true`

* step 5 start

`java -jar ./target/autogen-1.0.1-RELEASE.jar `

* classpath:template folder from gen
* classpath:templates folder from UI

[点击前往谷歌搜索](https://www.google.com.hk/)
 