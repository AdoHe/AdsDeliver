CREATE DATABASE  IF NOT EXISTS `adsdeliever` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `AdsDeliever`;
-- MySQL dump 10.13  Distrib 5.5.16, for osx10.5 (i386)
--
-- Host: localhost    Database: AdsDeliever
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
  PRIMARY KEY (`id`),
  KEY `user_fk1` (`us_Account`),
  KEY `user_fk2` (`us_Info`),
  CONSTRAINT `user_fk1` FOREIGN KEY (`us_Account`) REFERENCES `account` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `user_fk2` FOREIGN KEY (`us_Info`) REFERENCES `userInfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adverInfo`
--

DROP TABLE IF EXISTS `adverInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adverInfo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `af_BannerPic` varchar(100) NOT NULL,
  `af_BannerWordOne` varchar(100) NOT NULL,
  `af_BannerWordTwo` varchar(300) NOT NULL,
  `af_ContentPic` varchar(100) NOT NULL,
  `af_Contents` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adverInfo`
--

LOCK TABLES `adverInfo` WRITE;
/*!40000 ALTER TABLE `adverInfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `adverInfo` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userInfo`
--

DROP TABLE IF EXISTS `userInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userInfo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uf_Name` varchar(100) NOT NULL,
  `uf_Corperation` varchar(100) NOT NULL,
  `uf_MobilePhone` varchar(100) DEFAULT NULL,
  `uf_Telephone` varchar(100) DEFAULT NULL,
  `uf_Address` varchar(100) NOT NULL,
  `uf_Status` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userInfo`
--

LOCK TABLES `userInfo` WRITE;
/*!40000 ALTER TABLE `userInfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `userInfo` ENABLE KEYS */;
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
  CONSTRAINT `av_fk2` FOREIGN KEY (`av_Info`) REFERENCES `adverInfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `av_fk3` FOREIGN KEY (`av_User`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertisement`
--

LOCK TABLES `advertisement` WRITE;
/*!40000 ALTER TABLE `advertisement` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-26 19:31:05
