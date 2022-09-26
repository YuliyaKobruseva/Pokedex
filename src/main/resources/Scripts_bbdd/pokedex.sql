CREATE DATABASE  IF NOT EXISTS `pokedex` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pokedex`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pokedex
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemon_type`
--

DROP TABLE IF EXISTS `pokemon_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pokemon_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon_type`
--

LOCK TABLES `pokemon_type` WRITE;
/*!40000 ALTER TABLE `pokemon_type` DISABLE KEYS */;
INSERT INTO `pokemon_type` VALUES (1,'NORMAL'),(2,'FIRE'),(3,'WATER'),(4,'GRASS'),(5,'ELECTRIC'),(6,'ICE'),(7,'FIGHTING'),(8,'POISON'),(9,'GROUND'),(10,'FLYING'),(11,'PSYCHIC'),(12,'BUG'),(13,'ROCK'),(14,'GHOST'),(15,'DARK'),(16,'DRAGON'),(17,'STEEL'),(18,'FAIRY');
/*!40000 ALTER TABLE `pokemon_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemon_types_relations`
--

DROP TABLE IF EXISTS `pokemon_types_relations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon_types_relations` (
  `pokemon_id` int NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`pokemon_id`,`type_id`),
  KEY `id_type_idx` (`type_id`),
  CONSTRAINT `id_pokemon` FOREIGN KEY (`pokemon_id`) REFERENCES `pokemons` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_type` FOREIGN KEY (`type_id`) REFERENCES `pokemon_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon_types_relations`
--

LOCK TABLES `pokemon_types_relations` WRITE;
/*!40000 ALTER TABLE `pokemon_types_relations` DISABLE KEYS */;
INSERT INTO `pokemon_types_relations` VALUES (2,2),(4,2),(2,3),(3,3),(8,9),(9,9),(7,10),(5,12),(6,12),(7,12),(8,13),(9,13);
/*!40000 ALTER TABLE `pokemon_types_relations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemons`
--

DROP TABLE IF EXISTS `pokemons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemons` (
  `id` int NOT NULL AUTO_INCREMENT,
  `species` varchar(255) NOT NULL,
  `cp` int NOT NULL,
  `hp` int NOT NULL,
  `favourite` tinyint NOT NULL DEFAULT '0',
  `max_height` double NOT NULL,
  `max_weight` double NOT NULL,
  `min_height` double NOT NULL,
  `min_weight` double NOT NULL,
  `evolution` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemons`
--

LOCK TABLES `pokemons` WRITE;
/*!40000 ALTER TABLE `pokemons` DISABLE KEYS */;
INSERT INTO `pokemons` VALUES (2,'Squirtle',891,1008,0,10.13,0.44,0.56,7.88,3),(3,'Wartortle',1123,1685,1,11.89,0.57,0.96,10.14,0),(4,'Charmander',458,859,0,11.34,0.56,0.75,6.85,0),(5,'Caterpie',145,586,0,0.3,2.9,0.12,1.56,6),(6,'Metapod',698,1458,0,0.7,9.9,0.37,2.45,7),(7,'ButterFree',1897,2586,1,1.1,32,0.8,10,0),(8,'Golem',657,784,0,1.4,30,0.74,14,9),(9,'Geodude',3569,7854,1,0.4,20,0.12,5,0);
/*!40000 ALTER TABLE `pokemons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemons_evolutions`
--

DROP TABLE IF EXISTS `pokemons_evolutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemons_evolutions` (
  `pokemon_id` int NOT NULL,
  `evolutions_id` int NOT NULL,
  UNIQUE KEY `UK_ylelexwipi4uwgjhjdmkhks6` (`evolutions_id`),
  KEY `FKoyest3pugm7s1ilhbv6kp5rtm` (`pokemon_id`),
  CONSTRAINT `FKakewad4etuynat7spvmy53qgg` FOREIGN KEY (`evolutions_id`) REFERENCES `pokemons` (`id`),
  CONSTRAINT `FKoyest3pugm7s1ilhbv6kp5rtm` FOREIGN KEY (`pokemon_id`) REFERENCES `pokemons` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemons_evolutions`
--

LOCK TABLES `pokemons_evolutions` WRITE;
/*!40000 ALTER TABLE `pokemons_evolutions` DISABLE KEYS */;
/*!40000 ALTER TABLE `pokemons_evolutions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-27  0:04:35
