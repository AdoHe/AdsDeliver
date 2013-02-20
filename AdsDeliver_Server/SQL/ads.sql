-- MySQL dump 10.13  Distrib 5.5.28, for Win32 (x86)
--
-- Host: localhost    Database: adsdeliever
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ac_Balance` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,101),(2,0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `ad_Name` varchar(100) NOT NULL,
  `ad_Password` varchar(100) NOT NULL,
  `ad_Level` tinyint(4) NOT NULL DEFAULT '1',
  `ad_Rand` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (1,'admin','446b32dd1e7d1c609dfb0bdb354a3ff07f63cc21',1,'vPUt})h+');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adverinfo`
--

DROP TABLE IF EXISTS `adverinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adverinfo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `af_BannerPic` varchar(500) DEFAULT NULL,
  `af_BannerWordOne` varchar(100) NOT NULL,
  `af_BannerWordTwo` varchar(300) NOT NULL,
  `af_ContentPic` varchar(500) DEFAULT NULL,
  `af_Contents` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adverinfo`
--

LOCK TABLES `adverinfo` WRITE;
/*!40000 ALTER TABLE `adverinfo` DISABLE KEYS */;
INSERT INTO `adverinfo` VALUES (36,'/AdsDeliver_Server/upload/1357573036582_11569.jpg','一个标题啊','这也是一个标题啊','/AdsDeliver_Server/upload/1357572246265_89964.jpg','<p>我的一个蛋啊 真的是疼的和那啊</p>\n<p><span style=\"white-space: pre;\"> </span>法拉赫过来啊</p>\n<p><span style=\"white-space: pre;\"> </span>见过啦经过阿哥啊 噶九个个啊管理局&nbsp;</p>\n<p>修改一下</p>'),(37,'/AdsDeliver_Server/upload/1357572512890_84074.jpg','一个标题','噶九格拉','/AdsDeliver_Server/upload/1357572298177_94126.jpg','<p>我的那个差噶</p>\n<p><span style=\"white-space: pre;\"> </span>干辣椒<span style=\"white-space: pre;\"> </span>寂静岭</p>\n<p>&nbsp;赶紧啊了解</p>\n<p>修改广告</p>'),(38,'/AdsDeliver_Server/upload/1357575241247_69163.jpg','1','1','/AdsDeliver_Server/upload/1357575246031_15869.jpg','<p>fag</p>');
/*!40000 ALTER TABLE `adverinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advertisement`
--

DROP TABLE IF EXISTS `advertisement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertisement` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `av_Name` varchar(100) NOT NULL,
  `av_Address` varchar(100) NOT NULL,
  `av_Status` tinyint(4) NOT NULL DEFAULT '0',
  `av_ClickTimes` int(10) unsigned NOT NULL DEFAULT '0',
  `av_ShowTimes` int(10) unsigned NOT NULL DEFAULT '0',
  `av_PublishTime` datetime NOT NULL DEFAULT '1000-01-01 00:00:00',
  `av_Location` bigint(20) unsigned NOT NULL,
  `av_Info` int(10) unsigned NOT NULL,
  `av_User` int(10) unsigned NOT NULL,
  `av_Desc` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `av_fk1` (`av_Location`),
  KEY `av_fk2` (`av_Info`),
  KEY `av_fk3` (`av_User`),
  KEY `clicktimes` (`av_ClickTimes`) USING BTREE,
  KEY `showtimes` (`av_ShowTimes`) USING BTREE,
  CONSTRAINT `av_fk1` FOREIGN KEY (`av_Location`) REFERENCES `location` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `av_fk2` FOREIGN KEY (`av_Info`) REFERENCES `adverinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `av_fk3` FOREIGN KEY (`av_User`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisement`
--

LOCK TABLES `advertisement` WRITE;
/*!40000 ALTER TABLE `advertisement` DISABLE KEYS */;
INSERT INTO `advertisement` VALUES (33,'特斯特1','上海市家情趣',1,0,0,'2013-01-07 23:24:23',39,36,1,'等待审核中'),(34,'特斯特2','上海是交给',2,0,0,'2013-01-07 23:25:10',40,37,1,'正在运行中'),(35,'womenxu','shanghaishi',2,0,1,'2013-01-08 00:14:08',41,38,1,'正在运行中');
/*!40000 ALTER TABLE `advertisement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `lc_Longitude` float NOT NULL,
  `lc_Latitude` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lgtude` (`lc_Longitude`) USING BTREE,
  KEY `latude` (`lc_Latitude`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (4,121.815,31.1496),(5,121.28,31.3633),(6,120.236,30.2169),(7,121.28,31.3781),(8,121.08,31.3077),(9,121.507,31.632),(10,121.275,31.3699),(11,121.188,31.2931),(12,121.508,31.2802),(13,121.491,31.2431),(14,117.852,31.0879),(15,121.773,31.0754),(16,121.817,31.1546),(17,121.809,31.1526),(18,121.776,31.1022),(19,121.655,31.1635),(20,121.809,31.1516),(21,121.278,31.3689),(22,121.424,31.2495),(23,121.29,31.3788),(24,121.819,31.1516),(25,120.065,30.7008),(26,121.579,31.2178),(27,121.439,31.2959),(28,121.631,31.208),(29,121.493,31.2593),(30,121.278,31.3729),(31,121.815,31.1546),(32,121.276,31.3729),(33,121.816,31.1496),(34,121.813,31.1516),(35,121.814,31.1516),(36,121.644,31.1724),(37,121.632,31.1664),(38,121.43,31.2485),(39,121.506,31.2287),(40,121.739,31.1477),(41,121.222,31.2912);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `pc_Banner` float NOT NULL,
  `pc_Content` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES (1,0.3,0.9);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `re_Date` datetime NOT NULL DEFAULT '1000-01-01 00:00:00',
  `re_Income` int(11) NOT NULL DEFAULT '0',
  `re_Outcome` int(11) NOT NULL DEFAULT '0',
  `re_Balance` int(11) NOT NULL DEFAULT '0',
  `re_Category` varchar(100) NOT NULL,
  `re_Account` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `re_fk` (`re_Account`),
  CONSTRAINT `re_fk` FOREIGN KEY (`re_Account`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (14,'2013-01-07 21:02:40',100,0,101,'充值',1),(15,'2013-01-07 21:05:32',100,0,201,'充值',1),(16,'2013-01-07 21:08:35',100,0,301,'充值',1),(17,'2013-01-07 21:12:09',100,0,401,'充值',1),(18,'2013-01-07 21:26:23',1,0,402,'充值',1),(19,'2013-01-08 00:14:48',0,1,101,'广告费扣除',1);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `us_Name` varchar(100) NOT NULL,
  `us_Password` varchar(100) NOT NULL,
  `us_Info` int(10) unsigned NOT NULL,
  `us_Account` int(10) unsigned NOT NULL,
  `us_Rand` varchar(100) NOT NULL,
  `us_SessionId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_fk1` (`us_Account`),
  KEY `user_fk2` (`us_Info`),
  CONSTRAINT `user_fk1` FOREIGN KEY (`us_Account`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `user_fk2` FOREIGN KEY (`us_Info`) REFERENCES `userinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'1','80090dafcb347616302dec5d929cc81a7f68cde1',1,1,'3-.K5-Bq','0'),(2,'webservice','06d92ca22a87d7679341c34429baaa188485fc69',2,2,'&D^B:Tg2','0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uf_Name` varchar(100) NOT NULL,
  `uf_Corperation` varchar(100) NOT NULL,
  `uf_MobilePhone` varchar(100) DEFAULT NULL,
  `uf_Telephone` varchar(100) DEFAULT NULL,
  `uf_Address` varchar(100) NOT NULL,
  `uf_Status` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'TonyHe','上海腾讯','15900774086','010-29292929','同济大学',0),(2,'Tony','shanghai','15900664086','010-29292929','shanghsishi',0);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-20 13:04:01
