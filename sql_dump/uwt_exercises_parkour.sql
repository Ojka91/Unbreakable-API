-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: uwt
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `exercises_parkour`
--

DROP TABLE IF EXISTS `exercises_parkour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercises_parkour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `variation` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `level` int(11) DEFAULT NULL,
  `freerunning` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercises_parkour`
--

LOCK TABLES `exercises_parkour` WRITE;
/*!40000 ALTER TABLE `exercises_parkour` DISABLE KEYS */;
INSERT INTO `exercises_parkour` VALUES (1,'Vault','Safety',1,0),(2,'Vault','Side',1,0),(3,'Vault','Lazy',1,0),(4,'Vault','Turn',1,0),(5,'Vault','Gate',1,0),(6,'Vault','Bar leap',1,0),(7,'Vault','Cast',2,0),(8,'Vault','Rail Flare',2,0),(9,'Vault','Speed',2,0),(10,'Vault','Turn 360',2,1),(11,'Vault','Kong',2,0),(12,'Vault','Under bar',2,0),(13,'Vault','Reverse',2,0),(14,'Vault','Tic Tac',2,0),(15,'Vault','Dive kong',3,0),(16,'Vault','Reverse 360',3,1),(17,'Vault','Dash',3,0),(18,'Vault','360 under bar',3,0),(19,'Vault','Leghook underbar',3,1),(20,'Vault','Reverse touchdown',3,0),(21,'Vault','Reverse doubleleg',4,1),(22,'Vault','Kash',4,0),(23,'Vault','Double Kong',4,0),(24,'Vault','Palm spin',4,0),(25,'Vault','Reverse Kong',4,0),(26,'Vault','Turn 540/720',4,1),(27,'Vault','Reverse 540/720',5,1),(28,'Vault','Reverse palm spin',5,1),(29,'Vault','Palm spin flare',5,1),(30,'Vault','Reverse kong 180',5,0),(31,'Vault','Handstand kong drop',5,1),(32,'Vault','Triple kong',6,0),(33,'Vault','Rail spring',6,1),(34,'Vault','Rail roll',7,1),(35,'Vault','Kong front',7,1),(36,'Vault','Dash bomb',7,1),(37,'Wall','Cat leap',1,0),(38,'Wall','Crane jump',1,0),(39,'Wall','Wall run',2,0),(40,'Wall','Tic Tac',2,0),(41,'Wall','Split leg wedge',2,0),(42,'Wall','360 wall run',3,0),(43,'Wall','Cat to cat',3,0),(44,'Wall','Corner wall run',3,0),(45,'Wall','Pop up',3,0),(46,'Wall','Wall kong',4,0),(47,'Wall','Dino pop up',4,0),(48,'Wall','Double wall run',4,0),(49,'Wall','Full body wedge',4,0),(50,'Wall','Wall spin',5,0),(51,'Wall','Wall flip',5,1),(52,'Wall','Palm flip',6,1),(53,'Wall','Inward side flip',7,1),(54,'Wall','Inward front flip',7,1),(55,'Wall','Wall flare',7,1);
/*!40000 ALTER TABLE `exercises_parkour` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-14 20:28:15
