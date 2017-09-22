CREATE DATABASE  IF NOT EXISTS `to_do_list_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `to_do_list_db`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: to_do_list_db
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `file_sharing`
--

DROP TABLE IF EXISTS `file_sharing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_sharing` (
  `file_sharing_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_file_id` int(11) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `shared_date` datetime DEFAULT NULL,
  `shared_by` varchar(45) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` datetime NOT NULL,
  PRIMARY KEY (`file_sharing_id`),
  KEY `file_sharing_1_idx` (`user_file_id`),
  KEY `file_sharing_2_idx` (`user_name`),
  KEY `file_sharing_3_idx` (`shared_by`),
  CONSTRAINT `file_sharing_1` FOREIGN KEY (`user_file_id`) REFERENCES `user_file` (`user_file_id`),
  CONSTRAINT `file_sharing_2` FOREIGN KEY (`user_name`) REFERENCES `user_master` (`user_name`),
  CONSTRAINT `file_sharing_3` FOREIGN KEY (`shared_by`) REFERENCES `user_master` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_sharing`
--

LOCK TABLES `file_sharing` WRITE;
/*!40000 ALTER TABLE `file_sharing` DISABLE KEYS */;
/*!40000 ALTER TABLE `file_sharing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendship_status_master`
--

DROP TABLE IF EXISTS `friendship_status_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendship_status_master` (
  `friendship_status_id` varchar(45) NOT NULL,
  `status_code` varchar(45) NOT NULL,
  `status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`friendship_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendship_status_master`
--

LOCK TABLES `friendship_status_master` WRITE;
/*!40000 ALTER TABLE `friendship_status_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `friendship_status_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_file`
--

DROP TABLE IF EXISTS `user_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_file` (
  `user_file_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `user_file` blob NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` datetime NOT NULL,
  PRIMARY KEY (`user_file_id`),
  KEY `user_file_1_idx` (`user_name`),
  CONSTRAINT `user_file_1` FOREIGN KEY (`user_name`) REFERENCES `user_master` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_file`
--

LOCK TABLES `user_file` WRITE;
/*!40000 ALTER TABLE `user_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_friendship`
--

DROP TABLE IF EXISTS `user_friendship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_friendship` (
  `user_friendship_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name_initiator` varchar(45) NOT NULL DEFAULT '',
  `user_name_friend` varchar(45) NOT NULL,
  `friendship_status` varchar(45) NOT NULL,
  `created_by` varchar(45) NOT NULL,
  `creataed_date` datetime NOT NULL,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` datetime NOT NULL,
  PRIMARY KEY (`user_friendship_id`),
  KEY `FK_user_friendship_1` (`user_name_initiator`),
  KEY `FK_user_friendship_2` (`user_name_friend`),
  KEY `FK_user_friendship_3` (`friendship_status`),
  CONSTRAINT `FK_user_friendship_1` FOREIGN KEY (`user_name_initiator`) REFERENCES `user_master` (`user_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_user_friendship_2` FOREIGN KEY (`user_name_friend`) REFERENCES `user_master` (`user_name`),
  CONSTRAINT `FK_user_friendship_3` FOREIGN KEY (`friendship_status`) REFERENCES `friendship_status_master` (`friendship_status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_friendship`
--

LOCK TABLES `user_friendship` WRITE;
/*!40000 ALTER TABLE `user_friendship` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_friendship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_master` (
  `user_name` varchar(45) NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `joining_date` datetime DEFAULT NULL,
  `created_by` varchar(45) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_by` varchar(45) NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `password` varchar(1000) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master`
--

LOCK TABLES `user_master` WRITE;
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
INSERT INTO `user_master` VALUES ('a','a','Some data','a','2017-09-19 01:44:23','a','2017-09-19 01:44:23','a','2017-09-19 01:44:23','a'),('c','d','a','b','2017-09-19 02:22:14','c','2017-09-19 02:22:14','c','2017-09-19 02:22:14','e'),('f','f','Some data','f','2017-09-19 02:20:20','f','2017-09-19 02:20:20','f','2017-09-19 02:20:20','f'),('v','v','Some data','v','2017-09-19 01:34:51','v','2017-09-19 01:34:51','v','2017-09-19 01:34:51','v'),('vinit','v.dsd@g.com','Vinit','Divekar','2017-09-19 01:31:16','vinit','2017-09-19 01:31:16','vinit','2017-09-19 01:31:16','vinit'),('vinitd','v.d@g.com','Vinit','Divekar','2017-09-18 10:55:05','vinitd','2017-09-18 10:55:05','vinitd','2017-09-18 10:55:05','vinit');
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-23  1:09:03
