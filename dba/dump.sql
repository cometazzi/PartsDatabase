-- MySQL dump 10.13  Distrib 8.0.41, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: parts_database
-- ------------------------------------------------------
-- Server version	8.0.41-0ubuntu0.24.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `package_types`
--

DROP TABLE IF EXISTS `package_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package_types` (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `package_name` varchar(15) DEFAULT NULL,
                                 `package_descr` varchar(75) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_types`
--

LOCK TABLES `package_types` WRITE;
/*!40000 ALTER TABLE `package_types` DISABLE KEYS */;
INSERT INTO `package_types` VALUES (1,'DIP-4','Dual-Inline Package, 2 Leads Per Side'),(2,'DIP-6','Dual-Inline Package, 3 Leads Per Side'),(3,'DIP-8','Dual-Inline Package, 8 Leads Per Side'),(4,'DIP-14','Dual-Inline Package, 7 Leads Per Side'),(5,'DIP-16','Dual-Inline Package, 8 Leads Per Side'),(6,'DIP-18','Dual-Inline Package, 9 Leads Per Side'),(7,'Dip-28','Dual-Inline Package, 14 Leads Per Side'),(8,'SIP-8','Single-Inline Package, 8 Leads In A Row'),(9,'TO-3','Large Metal Package, Chassis-Mount'),(10,'TO-5','Small Metal Package, 8.9mm Diameter'),(11,'TO-18','Small Metal Package, 4.7mm Diameter'),(12,'TO-92','Small Molded Plastic Package, 5mm Width'),(13,'TO-126','Square Flat Composite Package 8mm Width'),(14,'TO-220','Large Square Composite Package with Heatsink Mount');
/*!40000 ALTER TABLE `package_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partsImages`
--

DROP TABLE IF EXISTS `partsImages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partsImages` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `largeImage` varchar(25) NOT NULL,
                               `thumbImage` varchar(25) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partsImages`
--

LOCK TABLES `partsImages` WRITE;
/*!40000 ALTER TABLE `partsImages` DISABLE KEYS */;
INSERT INTO `partsImages` VALUES (1,'DIP-4','dip4_large.jpg'),(2,'DIP-6','dip6_large.jpg'),(3,'DIP-8','dip8_large.jpg'),(4,'DIP-14','dip14_large.jpg'),(5,'DIP-16','dip16_large.jpg'),(6,'DIP-18','dip18_large.jpg'),(7,'Dip-28','dip28_large.jpg'),(8,'SIP-8','sip8_large.jpg'),(9,'TO-3','to3_large.jpg'),(10,'TO-5','to5_large.jpg'),(11,'TO-18','to18_large.jpg'),(12,'TO-92','to92_large.jpg'),(13,'TO-126','to126_large.jpg'),(14,'TO-220','to220_large.jpg');
/*!40000 ALTER TABLE `partsImages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transistors`
--

DROP TABLE IF EXISTS `transistors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transistors` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `image_url` varchar(15) DEFAULT NULL,
                               `part_num` varchar(15) DEFAULT NULL,
                               `technology` varchar(15) DEFAULT NULL,
                               `descr` varchar(75) DEFAULT NULL,
                               `qty` int DEFAULT NULL,
                               `package_type` int DEFAULT NULL,
                               `cost` decimal(6,2) DEFAULT NULL,
                               `datasheet_url` varchar(25) DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               KEY `transistor_package_name_fk` (`package_type`),
                               CONSTRAINT `transistor_package_name_fk` FOREIGN KEY (`package_type`) REFERENCES `package_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transistors`
--

LOCK TABLES `transistors` WRITE;
/*!40000 ALTER TABLE `transistors` DISABLE KEYS */;
INSERT INTO `transistors` VALUES (1,'TO-92.jpg','2N2222','BJT','NPN Transistor, Small Signal',67,12,0.46,NULL),(2,'TO-92.jpg','2N2907','BJT','PNP Transistor, Small Signal',54,12,0.42,NULL),(3,'TO-3.jpg','2N3055','BJT','NPN Power Transistor, High Current',1,9,0.94,NULL),(4,'TO-92.jpg','2N3819','JFET','N-Channel JFET',30,12,1.42,NULL),(5,'TO-92.jpg','2N3904','BJT','NPN Transistor, Small Signal',273,12,0.02,NULL),(6,'TO-92.jpg','2N3906','BJT','PNP Transistor, Small Signal',312,12,0.02,NULL),(7,'TO-92.jpg','2N5087','BJT','PNP Transistor, Small Signal',22,12,0.32,NULL),(8,'TO-92.jpg','2N5089','BJT','NPN Small Signal Transistor, High Gain',24,12,0.75,NULL),(9,'TO-92.jpg','2N5401','BJT','PNP Transistor, High Voltage',10,12,0.15,NULL),(10,'TO-92.jpg','2N5457','JFET','N-Channel JFET',30,12,1.59,NULL),(11,'TO-92.jpg','2N5458','JFET','N-Channel JFET',30,12,0.99,NULL),(12,'TO-92.jpg','2N5551','BJT','NPN Transistor, High Voltage',10,12,0.12,NULL),(13,'TO-92.jpg','2N6027','PUJ','Silicon Programmable Uni-Junction Transistor',6,12,0.89,NULL),(14,'TO-92.jpg','2N7000','MOSFET','N-Channel MOSFET',130,12,0.35,NULL),(15,'TO-92.jpg','A1015','BJT','PNP Transistor, Medium Voltage',10,12,0.05,NULL),(16,'TO-92.jpg','A42','BJT','NPN Transistor, High Voltage',10,12,0.12,NULL),(17,'TO-92.jpg','A733','BJT','PNP Transistor, Medium Voltage',10,12,0.17,NULL),(18,'TO-92.jpg','A92','BJT','PNP Transistor, High Voltage',10,12,0.15,NULL),(19,'TO-92.jpg','BC327','BJT','PNP Transistor, Medium Current',137,12,0.07,NULL),(20,'TO-92.jpg','BC337','BJT','NPN Transistor, Medium Current',147,12,0.05,NULL),(21,'TO-92.jpg','BC338','BJT','NPN Transistor, Small Signal',20,12,0.14,NULL),(22,'TO-92.jpg','BC547','BJT','NPN Transistor, Small Signal',25,12,0.08,NULL),(23,'TO-92.jpg','BC548','BJT','NPN Transistor, Small Signal',20,12,0.10,NULL),(24,'TO-92.jpg','BC549','BJT','NPN Transistor, Medium Current',20,12,0.05,NULL),(25,'TO-92.jpg','BC557','BJT','NPN Transistor, Small Signal',52,12,0.08,NULL),(26,'TO-126.jpg','BD437','BJT','NPN Power Transistor, Medium Current',10,13,0.35,NULL),(27,'TO-126.jpg','BD438','BJT','PNP Power Transistor, Medium Current',10,13,0.35,NULL),(28,'TO-92.jpg','BS170','BJT','N-Channel MOSFET',72,12,0.15,NULL),(29,'TO-92.jpg','C1815','BJT','NPN Small Signal Transistor',110,12,0.06,NULL),(30,'TO-92.jpg','C9012','BJT','PNP Transistor, Small Signal',20,12,0.11,NULL),(31,'TO-92.jpg','C9013','BJT','NPN Transistor, Small Signal',30,12,0.08,NULL),(32,'TO-92.jpg','C9014','BJT','NPN Transistor, Small Signal',50,12,0.07,NULL),(33,'TO-92.jpg','C9015','BJT','PNP Transistor, Small Signal',10,12,0.07,NULL),(34,'TO-92.jpg','C9018','BJT','NPN Transistor, Small Signal',10,12,0.07,NULL),(35,'TO-92.jpg','C945','BJT','NPN Transistor, Small Signal',10,12,0.05,NULL),(36,'TO-220.jpg','IRF510','MOSFET','N-Channel MOSFET, Medium Voltage',10,14,1.09,NULL),(37,'TO-220.jpg','IRF530','MOSFET','N-Channel MOSFET, Medium Voltage',10,14,0.56,NULL),(38,'TO-220.jpg','IRF840','MOSFET','N-Channel Power MOSFET, High Voltage',15,14,0.87,NULL),(39,'TO-220.jpg','IRF9530','MOSFET','P-Channel MOSFET, Medium Voltage',10,14,0.73,NULL),(40,'TO-92.jpg','J201','JFET','N-Channel JFET',50,12,0.48,NULL),(41,'TO-92.jpg','MPSA13','DARLINGTON','NPN Darlington Transistor',120,12,0.10,NULL),(42,'TO-92.jpg','S8050','BJT','NPN Transistor, Medium Current',50,12,0.04,NULL),(43,'TO-92.jpg','S8550','BJT','PNP Transistor, Medium Current',50,12,0.09,NULL),(44,'TO-220.jpg','TIP120','BJT','NPN Power Darlington Transistor',1,14,0.24,NULL),(45,'TO-220.jpg','TIP31','BJT','NPN Transistor, Medium Current',10,14,0.39,NULL),(46,'TO-220.jpg','TIP32','BJT','PNP Transistor, Medium Current',10,14,0.27,NULL),(47,'TO-220.jpg','TIP41','BJT','NPN Transistor, Medium Current',10,14,0.36,NULL),(48,'TO-220.jpg','TIP42','BJT','PNP Transistor, Medium Current',12,14,0.46,NULL),(49,'TO-92.jpg','ZTX543','BJT','NPN Switching Transistor',25,12,0.48,NULL);
/*!40000 ALTER TABLE `transistors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-21 16:50:19
