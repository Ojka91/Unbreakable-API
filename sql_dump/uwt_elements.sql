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
-- Table structure for table `elements`
--

DROP TABLE IF EXISTS `elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sphere` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elements`
--

LOCK TABLES `elements` WRITE;
/*!40000 ALTER TABLE `elements` DISABLE KEYS */;
INSERT INTO `elements` VALUES (1,'strength','strength','Ability to apply force to a physical object by contracting the muscles.'),(2,'agility','agility','Ability to minimize the transition time from one movement pattern to another.'),(3,'flexibility','flexibility','Ability to elongate and increase the elasticity of the muscles.'),(4,'endurance','endurance','Ability to exert oneself and remain active for a long period of time.'),(5,'technique','technique','Ability to improve the manner in which a movement is executed.'),(6,'perception','senses','Ability to perceive and interpret the sensory information in order to understand the environment.'),(7,'power','strength','Ability to exert maximum force in the shortest period of time.'),(8,'hardness','strength','Ability of the body to absorb energy and be deformed without being damaged.'),(9,'speed','agility','Ability to increase the rate of change of one’s position.'),(10,'quickness','agility','Ability to minimize the cycle duration of an isolated or a repeated movement.'),(11,'precision','agility','Ability to control the direction and intensity of the moves.'),(12,'mobility','flexibility','Ability to increase the range of motion of the joints.'),(13,'stamina','endurance','Ability to perform a certain action at or near maximum capacity for an extended amount of time.'),(14,'muscular endurance','endurance','Ability of the muscles to repeatedly exert force against a resistance.'),(15,'apnea','endurance','Ability to increase the time of suspension of breathing.'),(16,'skill','technique','Ability to choose and perform the right techniques at the right time in order to achieve a purpose.'),(17,'coordination','technique','Ability to use different parts of the body together efficiently.'),(18,'balance','technique','Ability to distribute the weight evenly enabling oneself to remain steady.'),(19,'body awareness','senses','Ability to listen, feel and understand the responses of one’s body.'),(20,'reflexes','senses','Ability to decrease the time in response to a stimulus.'),(21,'concentration','senses','Ability to focus the mind in one single point.'),(22,'sensation control','senses','Ability to overcome the sensations that arise from the physical feelings.'),(23,'emotion control','senses','Ability to overcome the emotions that arise from the perception of danger.'),(24,'qi','senses','Ability to cultivate and control the body’s energy flow.');
/*!40000 ALTER TABLE `elements` ENABLE KEYS */;
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
