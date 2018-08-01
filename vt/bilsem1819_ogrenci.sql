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
-- Table structure for table `ogrenci`
--

DROP TABLE IF EXISTS `ogrenci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ogrenci` (
  `ogrenciTCNO` varchar(11) CHARACTER SET utf8 NOT NULL,
  `ogrenciAdi` varchar(45) CHARACTER SET utf8 NOT NULL,
  `ogrenciSoyadi` varchar(45) CHARACTER SET utf8 NOT NULL,
  `ogrenciBilsemNo` smallint(6) DEFAULT NULL,
  `dogumYeri` varchar(45) CHARACTER SET utf8 NOT NULL,
  `dogumTarihi` date NOT NULL,
  `tanilamaYili` int(11) NOT NULL,
  `tanimlananIl` int(11) NOT NULL,
  `ilkBilsemBaslamaYili` int(11) NOT NULL,
  `ilkBilsemBaslamaIli` int(11) NOT NULL,
  `cinsiyet` tinyint(4) NOT NULL,
  `orgunEgitimdekiOgretmenAdi` varchar(60) CHARACTER SET utf8 NOT NULL,
  `orgunEgitimSinifi` tinyint(4) NOT NULL,
  `orgunEgitimSubesi` varchar(4) CHARACTER SET utf8 NOT NULL,
  `surekliHastalik` varchar(80) CHARACTER SET utf8 DEFAULT NULL,
  `surekliKullanilanIlac` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `nakilGeldigiBilsem` int(11) DEFAULT NULL,
  `adres` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `kayitTarihi` date DEFAULT NULL,
  `velayet` int(11) NOT NULL,
  `fotograf` varchar(255) CHARACTER SET utf8 NOT NULL,
  `aileDurumu` tinyint(4) NOT NULL,
  `orgunEgitimokulNo` varchar(45) CHARACTER SET utf8 NOT NULL,
  `OrgunEgitimOkulu` int(11) NOT NULL,
  `danismanOgretmen` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ogrenciTCNO`),
  KEY `il_idx` (`tanimlananIl`),
  KEY `ilkBilsemili_idx` (`ilkBilsemBaslamaIli`),
  KEY `nakilGeldigiBilsem_idx` (`nakilGeldigiBilsem`),
  KEY `okul_idx` (`OrgunEgitimOkulu`),
  KEY `velisi-ogrenci_idx` (`velayet`),
  KEY `danismaogretmen_idx` (`danismanOgretmen`),
  CONSTRAINT `il-ogrenci` FOREIGN KEY (`tanimlananIl`) REFERENCES `il` (`ilKodu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ilkBilsemili` FOREIGN KEY (`ilkBilsemBaslamaIli`) REFERENCES `il` (`ilKodu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `nakilGeldigiBilsem` FOREIGN KEY (`nakilGeldigiBilsem`) REFERENCES `bilsemler` (`bilsemKodu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ogretmen-ogrenci-danisman` FOREIGN KEY (`danismanOgretmen`) REFERENCES `ogretmen` (`TC`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `okul-ogrenci` FOREIGN KEY (`OrgunEgitimOkulu`) REFERENCES `okul` (`okulKodu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `velisi-ogrenci` FOREIGN KEY (`velayet`) REFERENCES `velitipi` (`veliTipiKodu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ogrenci`
--

LOCK TABLES `ogrenci` WRITE;
/*!40000 ALTER TABLE `ogrenci` DISABLE KEYS */;
INSERT INTO `ogrenci` VALUES ('11111111111','EYLÜL N?SA','ÇAM',NULL,'S?L?VR?','1982-10-15',2018,1,2018,22,0,'MUSTAFA BARI?',2,'B',NULL,NULL,NULL,'ED?RNE ED?RNE','2018-07-15',1,'G:/foto/11111111111.jpg',1,'961',175,NULL),('22222222222','EYLÜL NISA','ÇAM',NULL,'EDIRNE','1982-10-15',2011,14,2018,7,0,'MUSTAFA BARI?',2,'A',NULL,NULL,NULL,'EDIRNE EDIRNE','2018-07-15',1,'G:/foto/22222222222.jpg',1,'961',175,NULL),('33333333333','EYLÜL N?SA','I?Ü??ÖÇ',NULL,'ARTV?N','1982-10-15',2015,1,2018,2,1,'Ü?I??ÇÖ',2,'?',NULL,NULL,NULL,'SDSDS SDSDFSDF','2018-07-15',1,'G:/foto/33333333333.jpg',0,'963',175,NULL),('44444444444','ÜĞIİŞÇÖ','ÜĞŞİÇÖ',NULL,'EDİRNE','1982-10-15',2018,1,2018,2,0,'MUSTAFA BARIŞ',2,'A',NULL,NULL,NULL,'ÜĞÜĞÜŞİİİİÇÇÖÖÖÖÜĞİŞÇÖI','2018-07-15',1,'G:/foto/44444444444.jpg',0,'961',142,NULL),('77777777777','Ü?I??ÇÖ','Ü?I??ÇÖ',NULL,'ED?RNE','1982-10-15',2017,23,2008,46,0,'MUSTAFA BARI?',2,'A',NULL,NULL,NULL,'FSDSDFSDF','2018-07-15',2,'G:/foto/77777777777.jpg',0,'962',3,NULL),('88888888888','Ü?I?ÇÖ','ÇAM',NULL,'Ü?I??ÇÖ','1982-10-15',2018,1,2000,2,0,'MUSTAFA BARI?',5,'?',NULL,NULL,NULL,'DGGFGHFGHFGH FHFGHF','2018-07-15',2,'G:/foto/88888888888.jpg',0,'696',117,NULL);
/*!40000 ALTER TABLE `ogrenci` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-01  0:03:26
