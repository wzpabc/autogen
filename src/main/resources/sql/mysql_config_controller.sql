-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: it
-- ------------------------------------------------------
-- Server version	5.7.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `config_controller`
--

DROP TABLE IF EXISTS `config_controller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table config_controller
(
  id             int auto_increment comment '主键',
  group_id       varchar(30)   not null  comment '组',
  table_schema   varchar(300)  null comment '数据库',
  table_name     varchar(150)  null comment '表名字',
  table_type     varchar(50)   null comment '表类型',
  table_desc     varchar(160)  null comment '备注',
  api_value      varchar(120)  null comment '接口',
  notes          varchar(1000) not null comment '详情',
  flag           varchar(100)  not null comment '标记',
  producers      varchar(160)  null comment '类型',
  required       varchar(11)   not null comment '要求权限',
  isdisabled     int           not null comment '是否禁用',
  construct      varchar(11)   not null comment '是否生成构造函数yes/no',
  ignored        int           null comment '是否在API中忽略',
  request_path   varchar(110)  null comment '请求路径',
  request_method varchar(40)   null comment '请求方法:GET/POST...',
  function_name  varchar(110)  null comment '方法名',
  query          varchar(4000) not null comment '查询语句',
  isunique           int           null comment '查询节果唯一:0/1',
  auth           int           null comment '是否要授权访问:0/1',
  update_date    datetime      null  comment '更新时间',
  constraint config_controller_pk
  unique (id)
);

alter table config_controller
  add primary key (id);

DROP TABLE IF EXISTS `temp_test_autogen_unique`;

create table temp_test_autogen_unique
as
select `table_schema`,`table_name` from information_schema.tables limit 5;

DROP TABLE IF EXISTS `temp_test_autogen_list`;

create table temp_test_autogen_list
as
select `table_schema`,`table_name` from information_schema.tables limit 5;


create index idx_unique_i on temp_test_autogen_unique(`table_schema`,`table_name` );
create index idx_i on temp_test_autogen_list(`table_schema`,`table_name` );

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_controller`
--

LOCK TABLES `config_controller` WRITE;
/*!40000 ALTER TABLE `config_controller` DISABLE KEYS */;

insert into config_controller(
    group_id,
    table_schema,
    table_name,
    table_type,
    table_desc,
    api_value,
    notes,
    flag,
    producers,
    required,
    isdisabled,
    construct,
    ignored,
    request_path,
    request_method,
    function_name,
    query,
    isunique,
    auth,
    update_date)
   SELECT
concat('_group_',substring_index( t.name,'_',1)) `group_id`,
database() table_schema,
t.name table_name,
'table' table_type,
concat('desc','_',t.name) table_desc,
concat('api','_',t.name) api_value,
concat('notes','_',t.name) notes,
concat('\"',t.name,'\"')flag,
'application/json' producers,
'true' required,
0 isdisabled,
'no' construct,
0 ignored,
i.name request_path,
'GET'request_method,
i.name function_name,
concat('select * from ',t.name,' where ',GROUP_CONCAT(concat(f.name,'=\'\'') ORDER BY f.pos separator ' and ') ) query,
case when i.name like '%uniq%' then 1 else 0 end isunique,
0 auth,
CURRENT_TIMESTAMP() update_date
FROM information_schema.innodb_sys_tables t
JOIN information_schema.innodb_sys_indexes i USING (table_id)
JOIN information_schema.innodb_sys_fields f USING (index_id)
WHERE t.schema = database()
and t.name<>'config_controller'
and i.name<>'PRIMARY'
and i.name like 'idx%'
and t.name like 'temp_test_autogen%'
GROUP BY t.name,i.name limit 2
;


/*!40000 ALTER TABLE `config_controller` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-21 10:14:03
