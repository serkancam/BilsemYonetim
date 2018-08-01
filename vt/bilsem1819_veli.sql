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
-- Table structure for table `veli`
--

DROP TABLE IF EXISTS `veli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veli` (
  `veliKodu` int(11) NOT NULL AUTO_INCREMENT,
  `veliAdi` varchar(45) CHARACTER SET utf8 NOT NULL,
  `veliSoyadi` varchar(45) CHARACTER SET utf8 NOT NULL,
  `evAdres` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `isAdresi` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `evTelefonu` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `isTelefonu` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `cepTelefonu` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `epostaAdresi` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `ogrenimDurumu` int(11) DEFAULT NULL,
  `hayattami` tinyint(4) NOT NULL,
  `veliTipi` int(11) NOT NULL,
  `meslegi` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`veliKodu`),
  KEY `ogrenim_idx` (`ogrenimDurumu`),
  KEY `veliTipi_idx` (`veliTipi`),
  CONSTRAINT `ogrenim` FOREIGN KEY (`ogrenimDurumu`) REFERENCES `ogrenimdurumu` (`ogrenimDurumuKodu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `veliTipi` FOREIGN KEY (`veliTipi`) REFERENCES `velitipi` (`veliTipiKodu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veli`
--

LOCK TABLES `veli` WRITE;
/*!40000 ALTER TABLE `veli` DISABLE KEYS */;
/*!40000 ALTER TABLE `veli` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-01  0:03:36
