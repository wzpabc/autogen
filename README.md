# autogen
### first crete database in mysql 
* create database gen_mysql
#### import sql script into gen_mysql
* step 1. 

`mysql -uroot -proot gen_mysql < mysql_config_controller.sql
`

* step 2 .

`mvn test -Dtest=Generator`

`mvn test -Dtest=Generator#clear`

`mvn test -Dtest=Generator#execute`
* step 3 .

`mvn test -Dtest=com.tupperware.auto.controller.ConfigControllerControllerTest#testFormatSql
`  
* classpath:template folder from gen
* classpath:templates folder from UI

[点击前往谷歌搜索](https://www.google.com.hk/)
 