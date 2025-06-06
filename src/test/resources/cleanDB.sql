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
-- Table structure for table `capacitors`
--

DROP TABLE IF EXISTS `capacitors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `capacitors` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `image_url` int DEFAULT NULL,
                              `descr` varchar(25) DEFAULT NULL,
                              `value` varchar(15) DEFAULT NULL,
                              `qty` int DEFAULT NULL,
                              `cost` decimal(6,2) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `capacitors_package_types_id_fk` (`image_url`),
                              CONSTRAINT `capacitors_package_types_id_fk` FOREIGN KEY (`image_url`) REFERENCES `package_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capacitors`
--

LOCK TABLES `capacitors` WRITE;
/*!40000 ALTER TABLE `capacitors` DISABLE KEYS */;
INSERT INTO `capacitors` VALUES (1,24,'Ceramic Disc Capacitor','1pF',21,0.01),(2,24,'Ceramic Disc Capacitor','2pF',37,0.01),(3,24,'Ceramic Disc Capacitor','3pF',33,0.01),(4,24,'Ceramic Disc Capacitor','4pF',9,0.01),(5,24,'Ceramic Disc Capacitor','5pF',28,0.01),(6,24,'Ceramic Disc Capacitor','6pF',29,0.01),(7,24,'Ceramic Disc Capacitor','7pF',51,0.01),(8,24,'Ceramic Disc Capacitor','8pF',10,0.01),(9,24,'Ceramic Disc Capacitor','9pF',12,0.01),(10,24,'Ceramic Disc Capacitor','10pF',14,0.01),(11,24,'Ceramic Disc Capacitor','15pF',9,0.01),(12,24,'Ceramic Disc Capacitor','18pF',25,0.01),(13,24,'Ceramic Disc Capacitor','20pF',20,0.01),(14,24,'Ceramic Disc Capacitor','22pF',7,0.01),(15,24,'Ceramic Disc Capacitor','27pF',19,0.01),(16,24,'Ceramic Disc Capacitor','30pF',31,0.01),(17,24,'Ceramic Disc Capacitor','33pF',12,0.01),(18,24,'Ceramic Disc Capacitor','40pF',10,0.01),(19,24,'Ceramic Disc Capacitor','47pF',12,0.01),(20,24,'Ceramic Disc Capacitor','50pF',15,0.01),(21,24,'Ceramic Disc Capacitor','56pF',29,0.01),(22,24,'Ceramic Disc Capacitor','68pF',34,0.01),(23,24,'Ceramic Disc Capacitor','82pF',33,0.01),(24,24,'Ceramic Disc Capacitor','100pF',31,0.01),(25,24,'Ceramic Disc Capacitor','120pF',93,0.01),(26,24,'Ceramic Disc Capacitor','140pF',42,0.01),(27,24,'Ceramic Disc Capacitor','150pF',22,0.01),(28,24,'Ceramic Disc Capacitor','180pF',18,0.01),(29,24,'Ceramic Disc Capacitor','220pF',55,0.01),(30,24,'Ceramic Disc Capacitor','300pF',63,0.01),(31,24,'Ceramic Disc Capacitor','330pF',2,0.01),(32,24,'Ceramic Disc Capacitor','470pF',14,0.01),(33,24,'Ceramic Disc Capacitor','560pF',7,0.01),(34,24,'Ceramic Disc Capacitor','680pF',16,0.01),(35,24,'Ceramic Disc Capacitor','820pF',10,0.01),(36,24,'Ceramic Disc Capacitor','1nF',22,0.01),(37,24,'Ceramic Disc Capacitor','1.5nF',15,0.01),(38,24,'Ceramic Disc Capacitor','2nF',14,0.01),(39,24,'Ceramic Disc Capacitor','2.2nF',31,0.01),(40,24,'Ceramic Disc Capacitor','3.3nF',19,0.01),(41,24,'Ceramic Disc Capacitor','4.7nF',13,0.01),(42,24,'Ceramic Disc Capacitor','6.8nF',42,0.01),(43,24,'Ceramic Disc Capacitor','10nF',29,0.01),(44,24,'Ceramic Disc Capacitor','15nF',10,0.01),(45,24,'Ceramic Disc Capacitor','20nF',0,0.01),(46,24,'Ceramic Disc Capacitor','22nF',28,0.01),(47,24,'Ceramic Disc Capacitor','33nF',37,0.01),(48,24,'Ceramic Disc Capacitor','75nF',27,0.01),(49,24,'Ceramic Disc Capacitor','68nF',15,0.01),(50,24,'Ceramic Disc Capacitor','100nF',11,0.01),(51,25,'Mylar Capacitor','.001uF',16,0.03),(52,25,'Mylar Capacitor','.0015uF',22,0.03),(53,25,'Mylar Capacitor','.002uF',32,0.03),(54,25,'Mylar Capacitor','.003uF',33,0.03),(55,25,'Mylar Capacitor','.0047uF',39,0.03),(56,25,'Mylar Capacitor','.0056uF',38,0.03),(57,25,'Mylar Capacitor','.0082uF',52,0.03),(58,25,'Mylar Capacitor','.01uF',27,0.03),(59,25,'Mylar Capacitor','.015uF',26,0.03),(60,25,'Mylar Capacitor','.018uF',33,0.03),(61,25,'Mylar Capacitor','.022uF',55,0.03),(62,25,'Mylar Capacitor','.027uF',45,0.03),(63,25,'Mylar Capacitor','.033uF',56,0.03),(64,25,'Mylar Capacitor','.047uF',24,0.03),(65,25,'Mylar Capacitor','.056uF',44,0.03),(66,25,'Mylar Capacitor','.068uF',30,0.03),(67,25,'Mylar Capacitor','.082uF',31,0.03),(68,25,'Mylar Capacitor','.1uF',109,0.03),(69,26,'Electrolytic Capacitor','.15uF',47,0.02),(70,26,'Electrolytic Capacitor','.22uF',35,0.02),(71,26,'Electrolytic Capacitor','.33uF',17,0.02),(72,26,'Electrolytic Capacitor','.47uF',22,0.02),(73,26,'Electrolytic Capacitor','1uF',8,0.02),(74,26,'Electrolytic Capacitor','2.2uF',12,0.02),(75,26,'Electrolytic Capacitor','3.3uF',28,0.02),(76,26,'Electrolytic Capacitor','4.7uF',44,0.02),(77,26,'Electrolytic Capacitor','10uF',98,0.05),(78,26,'Electrolytic Capacitor','22uF',83,0.05),(79,26,'Electrolytic Capacitor','33uF',49,0.05),(80,26,'Electrolytic Capacitor','47uF',53,0.05),(81,26,'Electrolytic Capacitor','100uF',102,0.05),(82,26,'Electrolytic Capacitor','220uF',97,0.05),(83,26,'Electrolytic Capacitor','270uF',49,0.05),(84,26,'Electrolytic Capacitor','470uF',33,0.05),(85,26,'Electrolytic Capacitor','1000uF',8,0.05),(86,26,'Electrolytic Capacitor','2200uF',7,0.05);
/*!40000 ALTER TABLE `capacitors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chip_amps`
--

DROP TABLE IF EXISTS `chip_amps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chip_amps` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `image_url` int DEFAULT NULL,
                             `part_num` varchar(15) DEFAULT NULL,
                             `technology` varchar(25) DEFAULT NULL,
                             `descr` varchar(50) DEFAULT NULL,
                             `qty` int DEFAULT NULL,
                             `package_type` int DEFAULT NULL,
                             `cost` decimal(6,2) DEFAULT NULL,
                             `datasheet_url` varchar(25) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `chip_amps_img_url_id_fk` (`image_url`),
                             KEY `chip_amps_package_types_id_fk` (`package_type`),
                             CONSTRAINT `chip_amps_img_url_id_fk` FOREIGN KEY (`image_url`) REFERENCES `package_types` (`id`),
                             CONSTRAINT `chip_amps_package_types_id_fk` FOREIGN KEY (`package_type`) REFERENCES `package_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chip_amps`
--

LOCK TABLES `chip_amps` WRITE;
/*!40000 ALTER TABLE `chip_amps` DISABLE KEYS */;
INSERT INTO `chip_amps` VALUES (1,14,'LM1875T','BJT','20W Audio Amplifier',2,14,2.99,'datasheets/LM1875.pdf'),(2,4,'LM380','BJT','2.5W Audio Amplifier',2,4,1.95,'datasheets/LM380.pdf'),(3,14,'LM383','BJT','7W Audio Amplifier',2,14,5.95,'datasheets/LM383.pdf'),(4,3,'LM386','BJT','500mW Audio Amplifier',14,3,0.95,'datasheets/LM386.pdf'),(5,4,'LM384','BJT','5W Audio Amplifier',2,4,1.95,'datasheets/LM384.pdf'),(6,3,'MC34119P','BJT','400mW Audio Amplifier',20,3,0.60,'datasheets/MC34119.pdf'),(7,8,'NJM2073','BJT','1-2W BTL Amplifier',20,7,0.48,'datasheets/NJM2073.pdf'),(8,3,'TBA820M','BJT','1.2W Audio Amplifier',10,3,1.20,'datasheets/TBA820.pdf'),(9,6,'TDA1517P','BJT','6W Stereo Audio Amplifier',10,6,0.90,'datasheets/TDA1517.pdf'),(10,14,'TDA2002','BJT','8W Audio Amplifier',2,14,2.95,'datasheets/TDA2002.pdf'),(11,14,'TDA2005','BJT','20W Audio Amplifier',1,14,1.20,'datasheets/TDA2005.pdf'),(12,3,'TDA2822M','BJT','1W Stereo Audio Amplifier',20,3,1.58,'datasheets/TDA2822.pdf'),(13,3,'TDA7052','BJT','1W Audio Amplifier',10,3,1.60,'datasheets/TDA7052.pdf'),(14,5,'TEA2025L','BJT','4.7W Audio Amplifier',2,5,0.36,'datasheets/TEA2025.pdf'),(15,7,'TPA3125','Class-D','10W Class-D Audio Amplifier',2,6,4.88,'datasheets/TPA3125.pdf');
/*!40000 ALTER TABLE `chip_amps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diodes`
--

DROP TABLE IF EXISTS `diodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diodes` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `image_url` int DEFAULT NULL,
                          `part_num` varchar(15) DEFAULT NULL,
                          `descr` varchar(75) DEFAULT NULL,
                          `qty` int DEFAULT NULL,
                          `package_type` int DEFAULT NULL,
                          `cost` decimal(6,2) DEFAULT NULL,
                          `datasheet_url` varchar(25) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `diodes_package_types_id_fk` (`image_url`),
                          KEY `diodes_package_types_id_fk_2` (`package_type`),
                          CONSTRAINT `diodes_package_types_id_fk` FOREIGN KEY (`image_url`) REFERENCES `package_types` (`id`),
                          CONSTRAINT `diodes_package_types_id_fk_2` FOREIGN KEY (`package_type`) REFERENCES `package_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diodes`
--

LOCK TABLES `diodes` WRITE;
/*!40000 ALTER TABLE `diodes` DISABLE KEYS */;
INSERT INTO `diodes` VALUES (1,20,'ORANGELED','Orange LED',37,20,0.06,NULL),(2,17,'REDLED','Red LED',139,17,0.03,NULL),(3,15,'WHITELED','White LED',20,15,0.05,NULL),(4,16,'BICOLORLED','Bicolor Green/Red LED',16,15,0.12,NULL),(5,17,'BLINKLED','Blinking Red LED',212,17,0.12,NULL),(6,15,'COLORSHIFTFAST','Color Shift LED Fast',10,15,0.46,NULL),(7,15,'COLORSHIFTSLOW','Color Shift LED Slow',9,15,0.46,NULL),(8,18,'BLUELED','Blue LED',47,18,0.06,NULL),(9,19,'YELLOWLED','Yellow LED',154,19,0.03,NULL),(10,17,'LOWPOWERLED','Low Power Red LED',22,17,0.15,NULL),(11,21,'1N34A','Germanium Diode',62,21,1.20,'datasheets/1N34.pdf'),(12,21,'1N60A','Germanium Diode',42,21,0.80,'datasheets/1N60.pdf'),(13,22,'1N4001','Rectifier Diode',57,22,0.02,'datasheets/1N4001.pdf'),(14,22,'1N4004','Rectifier Diode',77,22,0.02,'datasheets/1N4001.pdf'),(15,22,'1N4007','Rectifier Diode',94,22,0.02,'datasheets/1N4001.pdf'),(16,27,'1N4148','Small Signal Diode',167,27,0.02,'datasheets/1N4148.pdf'),(17,27,'1N914','Small Signal Diode',100,27,0.02,'datasheets/1N4148.pdf');
/*!40000 ALTER TABLE `diodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linear_ics`
--

DROP TABLE IF EXISTS `linear_ics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `linear_ics` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `image_url` int DEFAULT NULL,
                              `part_num` varchar(15) DEFAULT NULL,
                              `descr` varchar(75) DEFAULT NULL,
                              `qty` int DEFAULT NULL,
                              `package_type` int DEFAULT NULL,
                              `cost` decimal(6,2) DEFAULT NULL,
                              `datasheet_url` varchar(25) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `linear_ics_package_types_id_fk_2` (`package_type`),
                              CONSTRAINT `linear_ics_package_types_id_fk` FOREIGN KEY (`package_type`) REFERENCES `package_types` (`id`),
                              CONSTRAINT `linear_ics_package_types_id_fk_2` FOREIGN KEY (`package_type`) REFERENCES `package_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linear_ics`
--

LOCK TABLES `linear_ics` WRITE;
/*!40000 ALTER TABLE `linear_ics` DISABLE KEYS */;
INSERT INTO `linear_ics` VALUES (1,3,'LM311','Differential Comparator',4,3,0.23,'datasheets/LM311.pdf'),(2,4,'LM339','Quad Comparator',4,4,0.35,'datasheets/LM339.pdf'),(3,3,'LM555','Timer IC',27,3,0.19,'datasheets/LM555.pdf'),(4,4,'LM556','Dual Timer IC',8,4,0.34,'datasheets/LM556.pdf'),(5,14,'LM7805','5V Voltage Regulator',22,14,0.23,'datasheets/LM78XX.pdf'),(6,14,'LM7809','9V Voltage Regulator',39,14,0.33,'datasheets/LM78XX.pdf'),(7,14,'LM7812','12V Voltage Regulator',12,14,0.33,'datasheets/LM78XX.pdf'),(8,14,'LM7815','15V Voltage Regulator',21,14,0.28,'datasheets/LM78XX.pdf'),(9,14,'LM7824','24V Voltage Regulator',18,14,0.35,'datasheets/LM78XX.pdf'),(10,3,'TL072','Dual OpAmp',22,1,0.25,'datasheets/TL07x.pdf'),(11,4,'TL074','Quad OpAmp',42,4,0.30,'datasheets/TL07x.pdf'),(12,3,'JRC4558D','Dual OpAmp',8,1,0.30,'datasheets/JRC4558.pdf'),(13,3,'LM741','Single OpAmp',27,1,0.22,'datasheets/LM741.pdf');
/*!40000 ALTER TABLE `linear_ics` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_types`
--

LOCK TABLES `package_types` WRITE;
/*!40000 ALTER TABLE `package_types` DISABLE KEYS */;
INSERT INTO `package_types` VALUES (1,'DIP-4','Dual-Inline Package, 2 Leads Per Side'),(2,'DIP-6','Dual-Inline Package, 3 Leads Per Side'),(3,'DIP-8','Dual-Inline Package, 4 Leads Per Side'),(4,'DIP-14','Dual-Inline Package, 7 Leads Per Side'),(5,'DIP-16','Dual-Inline Package, 8 Leads Per Side'),(6,'DIP-18','Dual-Inline Package, 9 Leads Per Side'),(7,'DIP-28','Dual-Inline Package, 14 Leads Per Side'),(8,'SIP-8','Single-Inline Package, 8 Leads In A Row'),(9,'TO-3','Large Metal Package, Chassis-Mount'),(10,'TO-5','Small Metal Package, 8.9mm Diameter'),(11,'TO-18','Small Metal Package, 4.7mm Diameter'),(12,'TO-92','Small Molded Plastic Package, 5mm Width'),(13,'TO-126','Square Flat Composite Package 8mm Width'),(14,'TO-220','Large Square Composite Package with Heatsink Mount'),(15,'WhiteLED','White LED'),(16,'BIColorLED','Bi-Color LED'),(17,'RedLED','Red LED'),(18,'BlueLED','Blue LED'),(19,'YellowLED','Yellow LED'),(20,'OrangeLED','Orange LED'),(21,'DO-3','NOS Germanium Diode'),(22,'DO-5','Silicon Rectifier Diode'),(23,'R-1','Radial Metal Film Resistor'),(24,'C-1','Ceramic Disc Capacitor'),(25,'C-2','Mylar Polyfilm Capacitor'),(26,'C-3','Aluminum Body Electrolytic Capacitor'),(27,'DO-4','Glass-bodied Silicon Diode');
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partsImages`
--

LOCK TABLES `partsImages` WRITE;
/*!40000 ALTER TABLE `partsImages` DISABLE KEYS */;
INSERT INTO `partsImages` VALUES (1,'DIP-4','dip4.jpg'),(2,'DIP-6','dip6.jpg'),(3,'DIP-8','dip8.jpg'),(4,'DIP-14','dip14.jpg'),(5,'DIP-16','dip16.jpg'),(6,'DIP-18','dip18.jpg'),(7,'DIP-20','dip20.jpg'),(8,'SIP-8','sip8.jpg'),(9,'TO-3','to3.jpg'),(10,'TO-5','to5.jpg'),(11,'TO-18','to18.jpg'),(12,'TO-92','to92.jpg'),(13,'TO-126','to126.jpg'),(14,'TO-220','to220.jpg'),(15,'WhiteLED','whiteLED.jpg'),(16,'BIColorLED','bicolorLED.jpg'),(17,'RedLED','redLED.jpg'),(18,'BlueLED','blueLED.jpg'),(19,'YelloLED','yellowLED.jpg'),(20,'OrangeLED','orangeLED.jpg'),(21,'DO-3','germanium.jpg'),(22,'DO-5','rectifier.jpg'),(23,'R-1','resistor.jpg'),(24,'C-1','ceramicCap.jpg'),(25,'C-2','mylarCap.jpg'),(26,'C-3','electroCap.jpg'),(27,'DO-4','glassDiode.jpg');
/*!40000 ALTER TABLE `partsImages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resistors`
--

DROP TABLE IF EXISTS `resistors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resistors` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `image_url` int DEFAULT NULL,
                             `value` varchar(15) DEFAULT NULL,
                             `qty` varchar(15) DEFAULT NULL,
                             `cost` decimal(6,2) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `resistors_package_types_id_fk` (`image_url`),
                             CONSTRAINT `resistors_package_types_id_fk` FOREIGN KEY (`image_url`) REFERENCES `package_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resistors`
--

LOCK TABLES `resistors` WRITE;
/*!40000 ALTER TABLE `resistors` DISABLE KEYS */;
INSERT INTO `resistors` VALUES (1,23,'1','Lifetime Supply',0.01),(2,23,'10','Lifetime Supply',0.01),(3,23,'100','Lifetime Supply',0.01),(4,23,'1K','Lifetime Supply',0.01),(5,23,'10K','Lifetime Supply',0.01),(6,23,'100K','Lifetime Supply',0.01),(7,23,'1.2','Lifetime Supply',0.01),(8,23,'12','Lifetime Supply',0.01),(9,23,'120','Lifetime Supply',0.01),(10,23,'1.2K','Lifetime Supply',0.01),(11,23,'12K','Lifetime Supply',0.01),(12,23,'120K','Lifetime Supply',0.01),(13,23,'1.5','Lifetime Supply',0.01),(14,23,'15','Lifetime Supply',0.01),(15,23,'150','Lifetime Supply',0.01),(16,23,'1.5K','Lifetime Supply',0.01),(17,23,'15K','Lifetime Supply',0.01),(18,23,'150K','Lifetime Supply',0.01),(19,23,'1.8','Lifetime Supply',0.01),(20,23,'18','Lifetime Supply',0.01),(21,23,'180','Lifetime Supply',0.01),(22,23,'1.8K','Lifetime Supply',0.01),(23,23,'18K','Lifetime Supply',0.01),(24,23,'180K','Lifetime Supply',0.01),(25,23,'2','Lifetime Supply',0.01),(26,23,'20','Lifetime Supply',0.01),(27,23,'200','Lifetime Supply',0.01),(28,23,'2K','Lifetime Supply',0.01),(29,23,'20K','Lifetime Supply',0.01),(30,23,'200K','Lifetime Supply',0.01),(31,23,'2.2','Lifetime Supply',0.01),(32,23,'22','Lifetime Supply',0.01),(33,23,'220','Lifetime Supply',0.01),(34,23,'2.2K','Lifetime Supply',0.01),(35,23,'22K','Lifetime Supply',0.01),(36,23,'220K','Lifetime Supply',0.01),(37,23,'2.4','Lifetime Supply',0.01),(38,23,'24','Lifetime Supply',0.01),(39,23,'240','Lifetime Supply',0.01),(40,23,'2.4K','Lifetime Supply',0.01),(41,23,'24K','Lifetime Supply',0.01),(42,23,'240K','Lifetime Supply',0.01),(43,23,'2.7','Lifetime Supply',0.01),(44,23,'27','Lifetime Supply',0.01),(45,23,'270','Lifetime Supply',0.01),(46,23,'2.7K','Lifetime Supply',0.01),(47,23,'27K','Lifetime Supply',0.01),(48,23,'270K','Lifetime Supply',0.01),(49,23,'3','Lifetime Supply',0.01),(50,23,'30','Lifetime Supply',0.01),(51,23,'300','Lifetime Supply',0.01),(52,23,'3K','Lifetime Supply',0.01),(53,23,'30K','Lifetime Supply',0.01),(54,23,'300K','Lifetime Supply',0.01),(55,23,'3.3','Lifetime Supply',0.01),(56,23,'33','Lifetime Supply',0.01),(57,23,'330','Lifetime Supply',0.01),(58,23,'3.3K','Lifetime Supply',0.01),(59,23,'33K','Lifetime Supply',0.01),(60,23,'330K','Lifetime Supply',0.01),(61,23,'3.6','Lifetime Supply',0.01),(62,23,'36','Lifetime Supply',0.01),(63,23,'360','Lifetime Supply',0.01),(64,23,'3.6K','Lifetime Supply',0.01),(65,23,'36K','Lifetime Supply',0.01),(66,23,'360K','Lifetime Supply',0.01),(67,23,'3.9','Lifetime Supply',0.01),(68,23,'39','Lifetime Supply',0.01),(69,23,'39K','Lifetime Supply',0.01),(70,23,'390','Lifetime Supply',0.01),(71,23,'3.9K','Lifetime Supply',0.01),(72,23,'39K','Lifetime Supply',0.01),(73,23,'390K','Lifetime Supply',0.01),(74,23,'4.3','Lifetime Supply',0.01),(75,23,'43','Lifetime Supply',0.01),(76,23,'430','Lifetime Supply',0.01),(77,23,'4.3K','Lifetime Supply',0.01),(78,23,'430K','Lifetime Supply',0.01),(79,23,'4.7','Lifetime Supply',0.01),(80,23,'47','Lifetime Supply',0.01),(81,23,'470','Lifetime Supply',0.01),(82,23,'4.7K','Lifetime Supply',0.01),(83,23,'470K','Lifetime Supply',0.01),(84,23,'5.1','Lifetime Supply',0.01),(85,23,'51','Lifetime Supply',0.01),(86,23,'510','Lifetime Supply',0.01),(87,23,'5.1K','Lifetime Supply',0.01),(88,23,'51K','Lifetime Supply',0.01),(89,23,'510K','Lifetime Supply',0.01),(90,23,'5.6','Lifetime Supply',0.01),(91,23,'56','Lifetime Supply',0.01),(92,23,'560','Lifetime Supply',0.01),(93,23,'5.6K','Lifetime Supply',0.01),(94,23,'56K','Lifetime Supply',0.01),(95,23,'560K','Lifetime Supply',0.01),(96,23,'6.2','Lifetime Supply',0.01),(97,23,'62','Lifetime Supply',0.01),(98,23,'620','Lifetime Supply',0.01),(99,23,'6.2K','Lifetime Supply',0.01),(100,23,'62K','Lifetime Supply',0.01),(101,23,'620K','Lifetime Supply',0.01),(102,23,'6.8','Lifetime Supply',0.01),(103,23,'68','Lifetime Supply',0.01),(104,23,'680','Lifetime Supply',0.01),(105,23,'6.8K','Lifetime Supply',0.01),(106,23,'68K','Lifetime Supply',0.01),(107,23,'680K','Lifetime Supply',0.01),(108,23,'7.5','Lifetime Supply',0.01),(109,23,'75','Lifetime Supply',0.01),(110,23,'750','Lifetime Supply',0.01),(111,23,'7.5K','Lifetime Supply',0.01),(112,23,'75K','Lifetime Supply',0.01),(113,23,'750K','Lifetime Supply',0.01),(114,23,'8.2','Lifetime Supply',0.01),(115,23,'82','Lifetime Supply',0.01),(116,23,'820','Lifetime Supply',0.01),(117,23,'8.2K','Lifetime Supply',0.01),(118,23,'82K','Lifetime Supply',0.01),(119,23,'820K','Lifetime Supply',0.01),(120,23,'9.1','Lifetime Supply',0.01),(121,23,'91','Lifetime Supply',0.01),(122,23,'910','Lifetime Supply',0.01),(123,23,'9.1K','Lifetime Supply',0.01),(124,23,'91K','Lifetime Supply',0.01),(125,23,'910K','Lifetime Supply',0.01),(126,23,'1M','Lifetime Supply',0.01),(127,23,'10M','Lifetime Supply',0.01),(128,23,'100M','Lifetime Supply',0.01),(129,23,'1.2M','Lifetime Supply',0.01),(130,23,'12M','Lifetime Supply',0.01),(131,23,'120M','Lifetime Supply',0.01),(132,23,'1.8M','Lifetime Supply',0.01),(133,23,'18M','Lifetime Supply',0.01),(134,23,'1.5M','Lifetime Supply',0.01),(135,23,'15M','Lifetime Supply',0.01),(136,23,'2M','Lifetime Supply',0.01),(137,23,'20M','Lifetime Supply',0.01);
/*!40000 ALTER TABLE `resistors` ENABLE KEYS */;
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
INSERT INTO `transistors` VALUES (1,'11','2N2222','BJT','NPN Transistor, Small Signal',67,11,0.46,NULL),(2,'12','2N2907','BJT','PNP Transistor, Small Signal',54,12,0.42,NULL),(3,'9','2N3055','BJT','NPN Power Transistor, High Current',1,9,0.94,NULL),(4,'12','2N3819','JFET','N-Channel JFET',30,12,1.42,NULL),(5,'12','2N3904','BJT','NPN Transistor, Small Signal',273,12,0.02,NULL),(6,'12','2N3906','BJT','PNP Transistor, Small Signal',312,12,0.02,NULL),(7,'12','2N5087','BJT','PNP Transistor, Small Signal',22,12,0.32,NULL),(8,'12','2N5089','BJT','NPN Small Signal Transistor, High Gain',24,12,0.75,NULL),(9,'12','2N5401','BJT','PNP Transistor, High Voltage',10,12,0.15,NULL),(10,'12','2N5457','JFET','N-Channel JFET',30,12,1.59,NULL),(11,'12','2N5458','JFET','N-Channel JFET',30,12,0.99,NULL),(12,'12','2N5551','BJT','NPN Transistor, High Voltage',10,12,0.12,NULL),(13,'12','2N6027','PUJ','Silicon Programmable Uni-Junction Transistor',6,12,0.89,NULL),(14,'12','2N7000','MOSFET','N-Channel MOSFET',130,12,0.35,NULL),(15,'12','A1015','BJT','PNP Transistor, Medium Voltage',10,12,0.05,NULL),(16,'12','A42','BJT','NPN Transistor, High Voltage',10,12,0.12,NULL),(17,'12','A733','BJT','PNP Transistor, Medium Voltage',10,12,0.17,NULL),(18,'12','A92','BJT','PNP Transistor, High Voltage',10,12,0.15,NULL),(19,'12','BC327','BJT','PNP Transistor, Medium Current',137,12,0.07,NULL),(20,'12','BC337','BJT','NPN Transistor, Medium Current',147,12,0.05,NULL),(21,'12','BC338','BJT','NPN Transistor, Small Signal',20,12,0.14,NULL),(22,'12','BC547','BJT','NPN Transistor, Small Signal',25,12,0.08,NULL),(23,'12','BC548','BJT','NPN Transistor, Small Signal',20,12,0.10,NULL),(24,'12','BC549','BJT','NPN Transistor, Medium Current',20,12,0.05,NULL),(25,'12','BC557','BJT','NPN Transistor, Small Signal',52,12,0.08,NULL),(26,'13','BD437','BJT','NPN Power Transistor, Medium Current',10,13,0.35,NULL),(27,'13','BD438','BJT','PNP Power Transistor, Medium Current',10,13,0.35,NULL),(28,'12','BS170','BJT','N-Channel MOSFET',72,12,0.15,NULL),(29,'12','C1815','BJT','NPN Small Signal Transistor',110,12,0.06,NULL),(30,'12','C9012','BJT','PNP Transistor, Small Signal',20,12,0.11,NULL),(31,'12','C9013','BJT','NPN Transistor, Small Signal',30,12,0.08,NULL),(32,'12','C9014','BJT','NPN Transistor, Small Signal',50,12,0.07,NULL),(33,'12','C9015','BJT','PNP Transistor, Small Signal',10,12,0.07,NULL),(34,'12','C9018','BJT','NPN Transistor, Small Signal',10,12,0.07,NULL),(35,'12','C945','BJT','NPN Transistor, Small Signal',10,12,0.05,NULL),(36,'14','IRF510','MOSFET','N-Channel MOSFET, Medium Voltage',10,14,1.09,NULL),(37,'14','IRF530','MOSFET','N-Channel MOSFET, Medium Voltage',10,14,0.56,NULL),(38,'14','IRF840','MOSFET','N-Channel Power MOSFET, High Voltage',15,14,0.87,NULL),(39,'14','IRF9530','MOSFET','P-Channel MOSFET, Medium Voltage',10,14,0.73,NULL),(40,'12','J201','JFET','N-Channel JFET',50,12,0.48,NULL),(41,'12','MPSA13','DARLINGTON','NPN Darlington Transistor',120,12,0.10,NULL),(42,'12','S8050','BJT','NPN Transistor, Medium Current',50,12,0.04,NULL),(43,'12','S8550','BJT','PNP Transistor, Medium Current',50,12,0.09,NULL),(44,'14','TIP120','BJT','NPN Power Darlington Transistor',1,14,0.24,NULL),(45,'14','TIP31','BJT','NPN Transistor, Medium Current',10,14,0.39,NULL),(46,'14','TIP32','BJT','PNP Transistor, Medium Current',10,14,0.27,NULL),(47,'14','TIP41','BJT','NPN Transistor, Medium Current',10,14,0.36,NULL),(48,'14','TIP42','BJT','PNP Transistor, Medium Current',12,14,0.46,NULL),(49,'12','ZTX543','BJT','NPN Switching Transistor',25,12,0.48,NULL);
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

-- Dump completed on 2025-04-28 19:10:02
