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
-- Table structure for table `bilsemler`
--

DROP TABLE IF EXISTS `bilsemler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bilsemler` (
  `bilsemKodu` int(11) NOT NULL,
  `bilsemAdi` varchar(80) CHARACTER SET utf8 NOT NULL,
  `ilKodu` int(11) NOT NULL,
  PRIMARY KEY (`bilsemKodu`),
  KEY `il_idx` (`ilKodu`),
  CONSTRAINT `il-bilsem` FOREIGN KEY (`ilKodu`) REFERENCES `il` (`ilKodu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilsemler`
--

LOCK TABLES `bilsemler` WRITE;
/*!40000 ALTER TABLE `bilsemler` DISABLE KEYS */;
INSERT INTO `bilsemler` VALUES (1,'Adana BİLSEM',1),(2,'Adana Kozan BİLSEM',1),(3,'Adıyaman BİLSEM',2),(4,'Afyon Dumlupınar BİLSEM',3),(5,'Afyon Dinar BİLSEM',3),(6,'Ağrı BİLSEM',4),(7,'Aksaray BİLSEM',68),(8,'Amasya Şehit Ferhat Ünelli BİLSEM',5),(9,'Amasya Merzifon BİLSEM',5),(10,'Ankara Mamak BİLSEM',6),(11,'Ankara Yasemin Karakaya BİLSEM',6),(12,'Ankara Altındağ Şehit Hüseyin Gültekin BİL.',6),(13,'Ankara Yenimahalle BİLSEM',6),(14,'Ankara Etimesgut BİLSEM',6),(15,'Antalya BİLSEM',7),(16,'Antalya Alanya BİLSEM',7),(17,'Antalya Finike BİLSEM',7),(18,'Ardahan BİLSEM',75),(19,'Artvin BİLSEM',8),(20,'Aydın Ticaret Borsası BİLSEM',9),(21,'Balıkesir Şehit Prof. Dr. İlhan Varank BİL.',10),(22,'Balıkesir Bandırma BİLSEM',10),(23,'Balıkesir Burhaniye BİLSEM',10),(24,'Bartın BİLSEM',74),(25,'Batman BİLSEM',72),(26,'Bayburt BİLSEM',69),(27,'Bilecik BİLSEM',11),(28,'Bingöl BİLSEM',12),(29,'Bitlis BİLSEM',13),(30,'Bolu BİLSEM',14),(31,'Burdur Alpaslan Ali Can BİLSEM',15),(32,'Bursa BTSO Kamil Tolon BİLSEM',16),(33,'Bursa Nilüfer Halil İnalcık BİLSEM',16),(34,'Bursa Mustafakemalpaşa Hamzabey BİLSEM',16),(35,'Çanakkale BİLSEM',17),(36,'Çankırı Ahmet Mecbur Efendi BİLSEM',18),(37,'Çorum BİLSEM',19),(38,'Denizli Nezihe-Derya Baltalı BİLSEM',20),(39,'Denizli Ülker Yörükoğlu BİLSEM',20),(40,'Diyarbakır BİLSEM',21),(41,'Düzce BİLSEM',81),(42,'Edirne Şehit Nefize Çetin Özsoy BİLSEM',22),(43,'Elazığ BİLSEM',23),(44,'Erzincan BİLSEM',24),(45,'Erzurum Remzi Sakaoğlu BİLSEM',25),(46,'Eskişehir Emine-Emir Şahbaz BİLSEM',26),(47,'Gaziantep Şahinbey Belediyesi BİLSEM',27),(48,'Giresun BİLSEM',28),(49,'Gümüşhane BİLSEM',29),(50,'Hakkâri BİLSEM',30),(51,'Hatay BİLSEM',31),(52,'Hatay İskenderun BİLSEM',31),(53,'Iğdır BİLSEM',76),(54,'Isparta Şehit Polis Mehmet Karacatilki BİL.',32),(55,'İstanbul BİLSEM',34),(56,'İstanbul Bahçelievler BİLSEM',34),(57,'İstanbul Başakşehir BİLSEM',34),(58,'İstanbul Beşiktaş BİLSEM',34),(59,'İstanbul Esenler BİLSEM',34),(60,'İstanbul Esenyurt BİLSEM',34),(61,'İstanbul Fatih BİLSEM',34),(62,'İstanbul Kadıköy BİLSEM',34),(63,'İstanbul Kartal BİLSEM',34),(64,'İstanbul Pendik BİLSEM',34),(65,'İstanbul Zeytinburnu BİLSEM',34),(66,'İzmir Narlıdere Sıdıka Akdemir BİLSEM',35),(67,'İzmir Bornova Şehit Fatih Satır BİLSEM',35),(68,'İzmir Çiğli Aydoğan Yağcı BİLSEM',35),(69,'İzmir Konak Şehit Ömer Halisdemir BİLSEM',35),(70,'Kahramanmaraş BİLSEM',46),(71,'Kahramanmaraş Elbistan BİLSEM',46),(72,'Karabük BİLSEM',78),(73,'Karaman BİLSEM',70),(74,'Kars Fahrettin Kırzıoğlu BİLSEM',36),(75,'Kastamonu BİLSEM',37),(76,'Kayseri Çetin Şen BİLSEM',38),(77,'Kırıkkale İl Özel İdaresi BİLSEM',71),(78,'Kırklareli BİLSEM',39),(79,'Kırklareli Lüleburgaz BİLSEM',39),(80,'Kırşehir Yusuf Demir BİLSEM',40),(81,'Kırşehir Kaman BİLSEM',40),(82,'Kocaeli İzmit BİLSEM',41),(83,'Konya BİLSEM',42),(84,'Konya Selçuklu BİLSEM',42),(85,'Konya Ereğli BİLSEM',42),(86,'Kütahya BİLSEM',43),(87,'Kütahya Tavşanlı BİLSEM',43),(88,'Malatya BİLSEM',44),(89,'Manisa BİLSEM',45),(90,'Manisa Akhisar BİLSEM',45),(91,'Manisa Salihli BİLSEM',45),(92,'Manisa Turgutlu BİLSEM',45),(93,'Mardin Prof. Dr. Aziz Sancar BİLSEM',47),(94,'Mersin Yenişehir Belediyesi BİLSEM',33),(95,'Mersin Silifke BİLSEM',33),(96,'Mersin Hadiye Kuradacı BİLSEM',33),(97,'Muğla BİLSEM',48),(98,'Muğla Fethiye BİLSEM',48),(99,'Muş BİLSEM',49),(100,'Nevşehir Halil İncekara BİLSEM',50),(101,'Niğde Akşemseddin BİLSEM',51),(102,'Ordu Dr. M. Hilmi Güler BİLSEM',52),(103,'Ordu Ünye BİLSEM',52),(104,'Osmaniye BİLSEM',80),(105,'Rize Fatma-Nuri Erkan BİLSEM',53),(106,'Rize Ardeşen BİLSEM',53),(107,'Sakarya BİLSEM',54),(108,'Samsun Rotary Kulübü BİLSEM',55),(109,'Siirt BİLSEM',56),(110,'Sinop BİLSEM',57),(111,'Sivas BİLSEM',58),(112,'Şanlıurfa BİLSEM',63),(113,'Şırnak BİLSEM',73),(114,'Tekirdağ BİLSEM',59),(115,'Tokat BİLSEM',60),(116,'Trabzon BİLSEM',61),(117,'Tunceli BİLSEM',62),(118,'Uşak BİLSEM',64),(119,'Van Yusuf Gökçenay BİLSEM',65),(120,'Yalova Atatürk BİLSEM',77),(121,'Yozgat Fatma Temel Turhan BİLSEM',66),(122,'Zonguldak Prof. Dr. Şaban Teoman Duralı B.',67);
/*!40000 ALTER TABLE `bilsemler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-01  0:03:35
