-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bilsem1819
-- ------------------------------------------------------
-- Server version	5.1.36-community-log

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
-- Table structure for table `devamettigiprogram`
--

DROP TABLE IF EXISTS `devamettigiprogram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devamettigiprogram` (
  `devamEttigiProgramId` int(11) NOT NULL AUTO_INCREMENT,
  `ogrenciTCNO` varchar(11) CHARACTER SET utf8 NOT NULL,
  `programKodu` int(11) NOT NULL,
  PRIMARY KEY (`devamEttigiProgramId`),
  KEY `programKodu_idx` (`programKodu`),
  KEY `ogrenciTCNO_idx` (`ogrenciTCNO`),
  CONSTRAINT `ogrenciTCNO-dep` FOREIGN KEY (`ogrenciTCNO`) REFERENCES `ogrenci` (`ogrenciTCNO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `programKodu-dep` FOREIGN KEY (`programKodu`) REFERENCES `program` (`programKodu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devamettigiprogram`
--

LOCK TABLES `devamettigiprogram` WRITE;
/*!40000 ALTER TABLE `devamettigiprogram` DISABLE KEYS */;
/*!40000 ALTER TABLE `devamettigiprogram` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-01  0:03:39
