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
CREATE TABLE `config_controller` (
  `id` int(11) DEFAULT NULL,
  `group_id` varchar(10) NOT NULL,
  `table_schema` varchar(300) DEFAULT NULL,
  `table_name` varchar(150) DEFAULT NULL,
  `table_type` varchar(50) DEFAULT NULL,
  `table_desc` varchar(160) DEFAULT NULL,
  `api_value` varchar(120) DEFAULT NULL,
  `notes` varchar(1000) NOT NULL,
  `flag` varchar(100) NOT NULL,
  `producers` varchar(160) DEFAULT NULL,
  `required` varchar(11) NOT NULL,
  `isdisabled` int(11) NOT NULL,
  `construct` varchar(11) NOT NULL,
  `ignored` int(11) DEFAULT NULL,
  `request_path` varchar(110) DEFAULT NULL,
  `request_method` varchar(40) DEFAULT NULL,
  `function_name` varchar(110) DEFAULT NULL,
  `query` varchar(4000) NOT NULL,
  `auth` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_controller`
--

LOCK TABLES `config_controller` WRITE;
/*!40000 ALTER TABLE `config_controller` DISABLE KEYS */;
INSERT INTO `config_controller` VALUES
(1,'01','gen_mysql','anl_v_kpi_status_rpt','table','达标情况','达标情况','达标情况','\"A).Tag System\"','application/json','true',0,'no',0,'getkpi','GET','getkpi','SELECT row_id,year,month,flag_year_month,date_type,organ_no,organ_name,organ_type,kpi,kpi_desc,true_amt,diff_amt,plan_amt,pre_amt,create_datetime,update_datetime  FROM anl_v_kpi_status_rpt where  organ_no=\'00\' and year=2018 and month=12 and organ_type=\'TUP\'',0,'2018-04-17 15:35:48')
,(2,'01','gen_mysql','anl_v_kpi_status_rpt','table','达标情况','达标情况','达标情况','\"A).Tag System\"','application/json','true',0,'no',0,'getkpi1','GET','getkpi1','SELECT row_id,year,month,flag_year_month,date_type,organ_no,organ_name,organ_type,kpi,kpi_desc,true_amt,diff_amt,plan_amt,pre_amt,create_datetime,update_datetime  FROM anl_v_kpi_status_rpt where  organ_no=\'00\' and year=2018 and month=12 and organ_type=\'TUP\' and date_type=\'季达标\'',0,'2018-04-17 15:35:48')
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
