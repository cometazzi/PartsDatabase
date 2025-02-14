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
-- Table structure for table `transistors`
--

DROP TABLE IF EXISTS `transistors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transistors` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `image_url` varchar(25) DEFAULT NULL,
                               `part_num` varchar(25) DEFAULT NULL,
                               `technology` varchar(25) DEFAULT NULL,
                               `descr` varchar(50) DEFAULT NULL,
                               `qty` int DEFAULT NULL,
                               `package` varchar(25) DEFAULT NULL,
                               `cost` decimal(6,2) DEFAULT NULL,
                               `datasheet_url` varchar(50) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transistors`
--

LOCK TABLES `transistors` WRITE;
/*!40000 ALTER TABLE `transistors` DISABLE KEYS */;
INSERT INTO `transistors` VALUES (1,'TO-92.jpg','2N2222','BJT','NPN Transistor, Small Signal',67,'TO-92',0.46,''),(2,'TO-92.jpg','2N2907','BJT','PNP Transistor, Small Signal',54,'TO-92',0.42,''),(3,'TO-3.jpg','2N3055','BJT','NPN Power Transistor, High Current',1,'TO-3',0.94,''),(4,'TO-92.jpg','2N3819','JFET','N-Channel JFET',30,'TO-92',1.42,''),(5,'TO-92.jpg','2N3904','BJT','NPN Transistor, Small Signal',273,'TO-92',0.02,''),(6,'TO-92.jpg','2N3906','BJT','PNP Transistor, Small Signal',312,'TO-92',0.02,''),(7,'TO-92.jpg','2N5087','BJT','PNP Transistor, Small Signal',22,'TO-92',0.32,''),(8,'TO-92.jpg','2N5089','BJT','NPN Small Signal Transistor, High Gain',24,'TO-92',0.75,''),(9,'TO-92.jpg','2N5401','BJT','PNP Transistor, High Voltage',10,'TO-92',0.15,''),(10,'TO-92.jpg','2N5457','JFET','N-Channel JFET',30,'TO-92',1.59,''),(11,'TO-92.jpg','2N5458','JFET','N-Channel JFET',30,'TO-92',0.99,''),(12,'TO-92.jpg','2N5551','BJT','NPN Transistor, High Voltage',10,'TO-92',0.12,''),(13,'TO-92.jpg','2N6027','PUJ','Silicon Programmable Uni-Junction Transistor',6,'TO-92',0.89,''),(14,'TO-92.jpg','2N7000','MOSFET','N-Channel MOSFET',130,'TO-92',0.35,''),(15,'TO-92.jpg','A1015','BJT','PNP Transistor, Medium Voltage',10,'TO-92',0.05,''),(16,'TO-92.jpg','A42','BJT','NPN Transistor, High Voltage',10,'TO-92',0.12,''),(17,'TO-92.jpg','A733','BJT','PNP Transistor, Medium Voltage',10,'TO-92',0.17,''),(18,'TO-92.jpg','A92','BJT','PNP Transistor, High Voltage',10,'TO-92',0.15,''),(19,'TO-92.jpg','BC327','BJT','PNP Transistor, Medium Current',137,'TO-92',0.07,''),(20,'TO-92.jpg','BC337','BJT','NPN Transistor, Medium Current',147,'TO-92',0.05,''),(21,'TO-92.jpg','BC338','BJT','NPN Transistor, Small Signal',20,'TO-92',0.14,''),(22,'TO-92.jpg','BC547','BJT','NPN Transistor, Small Signal',25,'TO-92',0.08,''),(23,'TO-92.jpg','BC548','BJT','NPN Transistor, Small Signal',20,'TO-92',0.10,''),(24,'TO-92.jpg','BC549','BJT','NPN Transistor, Medium Current',20,'TO-92',0.05,''),(25,'TO-92.jpg','BC557','BJT','NPN Transistor, Small Signal',52,'TO-92',0.08,''),(26,'SOT-32.jpg','BD437','BJT','NPN Power Transistor, Medium Current',10,'SOT-32',0.35,''),(27,'SOT-32.jpg','BD438','BJT','PNP Power Transistor, Medium Current',10,'SOT-32',0.35,''),(28,'TO-92.jpg','BS170','BJT','N-Channel MOSFET',72,'TO-92',0.15,''),(29,'TO-92.jpg','C1815','BJT','NPN Small Signal Transistor',110,'TO-92',0.06,''),(30,'TO-92.jpg','C9012','BJT','PNP Transistor, Small Signal',20,'TO-92',0.11,''),(31,'TO-92.jpg','C9013','BJT','NPN Transistor, Small Signal',30,'TO-92',0.08,''),(32,'TO-92.jpg','C9014','BJT','NPN Transistor, Small Signal',50,'TO-92',0.07,''),(33,'TO-92.jpg','C9015','BJT','PNP Transistor, Small Signal',10,'TO-92',0.07,''),(34,'TO-92.jpg','C9018','BJT','NPN Transistor, Small Signal',10,'TO-92',0.07,''),(35,'TO-92.jpg','C945','BJT','NPN Transistor, Small Signal',10,'TO-92',0.05,''),(36,'TO-220.jpg','IRF510','MOSFET','N-Channel MOSFET, Medium Voltage',10,'TO-220',1.09,''),(37,'TO-220.jpg','IRF530','MOSFET','N-Channel MOSFET, Medium Voltage',10,'TO-220',0.56,''),(38,'TO-220.jpg','IRF840','MOSFET','N-Channel Power MOSFET, High Voltage',15,'TO-220',0.87,''),(39,'TO-220.jpg','IRF9530','MOSFET','P-Channel MOSFET, Medium Voltage',10,'TO-220',0.73,''),(40,'TO-92.jpg','J201','JFET','N-Channel JFET',50,'TO-92',0.48,''),(41,'TO-92.jpg','MPSA13','DARLINGTON','NPN Darlington Transistor',120,'TO-92',0.10,''),(42,'TO-92.jpg','S8050','BJT','NPN Transistor, Medium Current',50,'TO-92',0.04,''),(43,'TO-92.jpg','S8550','BJT','PNP Transistor, Medium Current',50,'TO-92',0.09,''),(44,'TO-220.jpg','TIP120','BJT','NPN Power Darlington Transistor',1,'TO-220',0.24,''),(45,'TO-220.jpg','TIP31','BJT','NPN Transistor, Medium Current',10,'TO-220',0.39,''),(46,'TO-220.jpg','TIP32','BJT','PNP Transistor, Medium Current',10,'TO-220',0.27,''),(47,'TO-220.jpg','TIP41','BJT','NPN Transistor, Medium Current',10,'TO-220',0.36,''),(48,'TO-220.jpg','TIP42','BJT','PNP Transistor, Medium Current',12,'TO-220',0.46,''),(49,'TO-92.jpg','ZTX543','BJT','NPN Switching Transistor',25,'TO-92',0.48,'');
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

-- Dump completed on 2025-02-13 20:01:16