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
-- Table structure for table `exercises_athletics`
--

DROP TABLE IF EXISTS `exercises_athletics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercises_athletics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `variation` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `upper_body` tinyint(1) DEFAULT '0',
  `core` tinyint(1) DEFAULT '0',
  `lower_body` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercises_athletics`
--

LOCK TABLES `exercises_athletics` WRITE;
/*!40000 ALTER TABLE `exercises_athletics` DISABLE KEYS */;
INSERT INTO `exercises_athletics` VALUES (1,'Leg Swing','Front swing',0,0,1),(2,'Leg Swing','Side swing',0,0,1),(3,'Leg Swing','Back swing',0,0,1),(4,'Skipping & Leaping','Regular',0,0,1),(5,'Skipping & Leaping','Knee lifts',0,1,1),(6,'Skipping & Leaping','Back kicks',0,0,1),(7,'Skipping & Leaping','Forward leaps',0,0,1),(8,'Skipping & Leaping','Lateral leaps',0,0,1),(9,'Skipping & Leaping','Backward leaps',0,0,1),(10,'Skipping & Leaping','Wall knee lifts',0,1,1),(11,'Crawls & Walks','Cat walk (QM)',1,1,1),(12,'Crawls & Walks','Crouching Tiger (QM)',1,1,1),(13,'Crawls & Walks','Bounding (QM)',1,1,1),(14,'Crawls & Walks','Gorilla (QM)',1,1,1),(15,'Crawls & Walks','Frog jumps (QM)',1,1,1),(16,'Crawls & Walks','Monkey Roll (QM)',1,1,1),(17,'Crawls & Walks','Spider (QM)',1,1,1),(18,'Crawls & Walks','Lizard (QM)',1,1,1),(19,'Crawls & Walks','Chamaleon (QM)',1,1,1),(20,'Crawls & Walks','Scorpion (QM)',1,1,1),(21,'Crawls & Walks','Ostrich',0,1,1),(22,'Crawls & Walks','Leg front swing walk',0,0,1),(23,'Crawls & Walks','Pistol squat walk',0,0,1),(24,'Crawls & Walks','Handstand kick walk',1,1,1),(25,'Crawls & Walks','Undead (QM)',1,1,0),(26,'Crawls & Walks','Crab (QM)',1,1,1),(27,'Crawls & Walks','Crab roll (QM)',1,1,1),(28,'Crawls & Walks','Spring (QM)',1,1,1),(29,'Crawls & Walks','Horse walk',0,0,1),(30,'Crawls & Walks','Calves raise walk',0,0,1),(31,'Crawls & Walks','Duck walk',0,0,1),(32,'Crawls & Walks','Bunny hops',0,0,1),(33,'Crawls & Walks','Sneaking Ape',0,0,1),(34,'Mountain Climbers','Regular',1,1,1),(35,'Mountain Climbers','Crossover',1,1,1),(36,'Mountain Climbers','Outwards',1,1,1),(37,'Mountain Climbers','Double leg',1,1,1),(38,'Mountain Climbers','Double double leg',1,1,1),(39,'Mountain Climbers','Froggers',1,1,1),(40,'Mountain Climbers','Knee to elbow crossed',1,1,1),(41,'Burpee','Regular',1,1,1),(42,'Burpee','Sprawl',1,1,1),(43,'Burpee','Sprawl jump',1,1,1),(44,'Burpee','Sprawl push up',1,1,1),(45,'Burpee','Tuck jump',1,1,1),(46,'Burpee','Backflip',1,1,1),(47,'Burpee','Single leg',1,1,1),(48,'Burpee','Navy Seals',1,1,1),(49,'Burpee','Pull up',1,1,1),(50,'Jump','Box regular',0,0,1),(51,'Jump','Box single leg',0,0,1),(52,'Jump','Box flowing',0,0,1),(53,'Jump','Long regular',0,0,1),(54,'Jump','Long single leg',0,0,1),(55,'Jump','Long flowing',0,0,1),(56,'Jump','Precision regular',0,0,1),(57,'Jump','Precision single leg',0,0,1),(58,'Jump','Precision unleveled',0,0,1),(59,'Jump','Precision flowing',0,0,1),(60,'Jump','Striding',0,1,1),(61,'Line Hops','Single side to side',0,0,1),(62,'Line Hops','Single front and back',0,0,1),(63,'Line Hops','Double side to side',0,0,1),(64,'Line Hops','Double front and back',0,0,1),(65,'Line Hops','One leg back forth',0,0,1),(66,'Line Hops','One leg side to side',0,0,1),(67,'Rolls','Landing front roll',1,1,1),(68,'Rolls','Landing side roll',1,1,1),(69,'Rolls','Landing back roll',1,1,1),(70,'Rolls','Dive roll',1,1,1),(71,'Rope Skipping','Double leg',0,0,1),(72,'Rope Skipping','Single leg',0,0,1),(73,'Rope Skipping','Backwards',0,0,1),(74,'Rope Skipping','Double under',0,0,1),(75,'Cardio Jumps','Jumping jacks',1,0,1),(76,'Cardio Jumps','Flying jacks',1,0,1),(77,'Cardio Jumps','Split jumps',0,0,1),(78,'Cardio Jumps','Star jumps',1,0,1),(79,'Cardio Jumps','Spring jumps',0,0,1),(80,'Cardio Jumps','Tuck jumps',0,1,1),(81,'Cardio Jumps','Ski to sumo squat jump',0,0,1),(82,'Miscellanea','Fast feet',0,0,1),(83,'Miscellanea','Balance walk',1,1,1),(84,'Miscellanea','Balance run',1,1,1),(85,'Miscellanea','Standing knee to elbow',1,1,1),(86,'Miscellanea','Donkey kick',1,1,1),(87,'Miscellanea','Donkey double kick',1,1,1),(88,'Miscellanea','Up&down plank',1,1,0),(89,'Miscellanea','Plank jacks',1,1,1),(90,'Miscellanea','Up&down arm steps',1,1,0),(91,'Miscellanea','Half flare',1,1,1),(92,'Miscellanea','Flare',1,1,1),(93,'Miscellanea','Contrallateral plank side rotation',1,1,1),(94,'Miscellanea','Contrallateral plank front reversion',1,1,1),(95,'Miscellanea','Get ups front',1,1,1),(96,'Miscellanea','Get ups side',1,1,1);
/*!40000 ALTER TABLE `exercises_athletics` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-14 20:28:14
