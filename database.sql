-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: szrotex
-- ------------------------------------------------------
-- Server version	5.7.25

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
-- Table structure for table `boat`
--

DROP TABLE IF EXISTS `boat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boat` (
  `id` int(10) unsigned NOT NULL,
  `displacement` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKh8f4yp5p3wk7x40cnii9rlfny` FOREIGN KEY (`id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boat`
--

LOCK TABLES `boat` WRITE;
/*!40000 ALTER TABLE `boat` DISABLE KEYS */;
/*!40000 ALTER TABLE `boat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `id` int(10) unsigned NOT NULL DEFAULT '2',
  `brand` varchar(255) CHARACTER SET utf8 NOT NULL,
  `model` varchar(255) CHARACTER SET utf8 NOT NULL,
  `engine_capacity` double unsigned DEFAULT NULL,
  `engine_type` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `engine_power` int(10) unsigned DEFAULT NULL,
  `production_year` int(4) unsigned DEFAULT NULL,
  `doors_quantity` int(10) unsigned DEFAULT NULL,
  `transsmision` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `seats_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKfugwdpykh9kb35q1quro44hrm` FOREIGN KEY (`id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'BMW','M2',3,'Petrol',410,2018,5,'auto',4),(2,'Alfa Romeo','Stelvio',2,'Turbo',280,2017,5,'auto',5),(3,'Audi','A7',3,'Diesel',286,2018,5,'auto',5),(4,'Porsche','Cayenne',4.8,'Petrol',400,2015,5,'manual',5),(5,'Porsche','911 Targa 4',3.8,'Petrol',350,2014,3,'manual',2),(6,'Mazda','CX-3',2,'Petrol',150,2017,5,'auto',5),(7,'Mercedes Benz','SLS',6.2,'Petrol',571,2010,3,'manual',2),(8,'Mercedes Benz','Klasa G',6,'Petrol',630,2018,5,'auto',5),(9,'Mercedes Benz','GLK',3,'Diesel',224,2008,5,'auto',5),(10,'Maserati','Granturismo',4.7,'Petrol',460,2017,2,'auto',4),(11,'Lamborgihni','Aventador',6.5,'Petrol',740,2018,2,'auto',2),(12,'Ferrari ','458 Italia',5,'Petrol',605,2015,2,'auto',2),(13,'Tesla','Model S',4,'Electric',367,2014,5,'auto',5),(14,'Bentley','Continental',6,'Petrol',635,2015,2,'auto',4);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone` varchar(9) NOT NULL,
  `pesel` varchar(11) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `id_number` varchar(9) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `birth_date` date NOT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `street` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `apartment_number` varchar(10) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `postal_code` varchar(7) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'2019-04-13','maja.wasilewska@testgmail.com','Maja','Wasilewska','844231079','82030141900','ALJ678225','1982-03-01','Koszalin','Połczyńska','148','75-816'),(2,'2019-04-13','damian.laskowski@testwp.pl','Damian','Laskowski','454452444','80042264598','ADD394345','1980-04-22','Łódź','Piasta','148','93-562'),(3,'2019-04-13','oliwia.lewandowska@testonet.pl','Oliwia','Lewnadowska','219856483','63062386666','AXP071617','1963-06-23','Lublin','Sieciecha Wojciecha','19','20-381'),(4,'2019-04-13','michalina.pawlik@testo2.pl','Michalina','Pawlik','385863141','87051934285','AZV369785','1987-05-19','Kraków','Traczy','6','30-799'),(5,'2019-04-13','filip.jasinski@testwp.pl','Filip','Jasiński','86301814','49062723919','AOV128343','1949-06-27','Wrocław','Limanowska','27','54-029'),(6,'2019-04-13','anna.wlodarczyk@testgmail.com','Anna','Włodarczyk','229917576','72030860066','ATP235053','1972-03-08','Bydgoszcz','Sandowcza','53','85-435'),(7,'2019-04-13','maria.dudek@testwp.pl','Maria','Dudek','499662235','77111595446','AQA376752','1977-11-15','Kielce','Konstytucji','32','25-509'),(8,'2019-04-13','karol.skowronski@testonet.pl','Karol','Skowroński','875311434','86010579451','AGO868424','1986-01-05','Bydgoszcz','Karlowicza Mieczysława','51','85-092'),(9,'2019-04-13','lukasz.kaminski@test.com','Łukasz','Kamiński','139045332','77082222932','ASA467940','1977-08-22','Warszawa','Wilgi','81','04-831'),(10,'2019-04-13','krzysztof.krawczyk@najlepszamuzyka.pl','Krzysztof','Krawczyk','501423117','74101673818','AGK743705','1974-10-16','Poznań','Paderewskiego Ignacego','128','61-770'),(16,'2019-04-16','sdfds@wp.pl','ððśłłłćźźżą','a','123456789','12345678901','asd345678','2019-03-05','sdf','Ulicaas','112','32-050');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (30);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(10) unsigned DEFAULT NULL,
  `client_id` int(10) unsigned DEFAULT NULL,
  `date_start` datetime DEFAULT NULL,
  `date_end` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reservation_1_idx` (`vehicle_id`),
  KEY `FKoewar6f18rkn4iptr6da4oysv` (`client_id`),
  CONSTRAINT `FKoewar6f18rkn4iptr6da4oysv` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKrm327sr0rb11mme0kbsm37od5` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (29,12,1,'2019-04-02 00:00:00','2019-04-03 00:00:00'),(30,1,16,'2019-04-04 22:36:00','2019-04-11 13:36:00');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` char(32) NOT NULL,
  `salt` char(32) NOT NULL,
  `created_at` datetime NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@example.com','0a10553aa8f8a9b297ee7748b64bb346','97c26f1cfc6b906947f73401bbaf26b2','2019-03-24 19:21:43','admin','admin'),(2,'a','c336be70f95564207789b259dbdd79f0','c5a5193a6bfa98b7861cd9fe2eb49577','2019-03-13 20:05:22','dev','dev');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `price` decimal(10,2) unsigned DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `link_to_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,256.00,'blue','src/main/resources/assets/cars/bmwm2.png'),(2,214.00,'silver','src/main/resources/assets/cars/alfas.png'),(3,369.00,'white','src/main/resources/assets/cars/audia7.png'),(4,250.00,'black','src/main/resources/assets/cars/porschec.png'),(5,381.00,'white','src/main/resources/assets/cars/porschet.png'),(6,188.00,'blue','src/main/resources/assets/cars/mazdacx.png'),(7,499.00,'grey','src/main/resources/assets/cars/mbs.png'),(8,554.00,'black','src/main/resources/assets/cars/mbg.png'),(9,170.00,'white','src/main/resources/assets/cars/mbglk.png'),(10,388.00,'blue','src/main/resources/assets/cars/maseratig.png'),(11,532.00,'green','src/main/resources/assets/cars/lamborgihnia.png'),(12,444.00,'red','src/main/resources/assets/cars/ferrarii.png'),(13,259.00,'black','src/main/resources/assets/cars/teslas.png'),(14,421.00,'orange','src/main/resources/assets/cars/bentleyc.png');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-16 22:35:26
