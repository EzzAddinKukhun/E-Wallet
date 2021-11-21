-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sw_project_schema
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `SSN` int NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `BirthDate` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Location` varchar(45) NOT NULL,
  `Zip Code` int NOT NULL,
  PRIMARY KEY (`SSN`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Ezzo','123','10-9-2000','ee','ee','ee','ee',11),(10,'ana','456','5-6-2001','58','jkl;','789','dsged',56);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `date` varchar(45) NOT NULL,
  `amount` int NOT NULL,
  `company_name` varchar(45) NOT NULL,
  `sender_id` int NOT NULL,
  `service_name` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (3,'12-9-2000',600,'Hadara',11820706,'net'),(4,'12-9-2000',700,'Oredoo',11820706,'mobile'),(5,'12-9-2000',800,'Jawwal',11820706,'mobile'),(6,'12-9-2000',900,'Ashamal',11820706,'electricity');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `amount` int NOT NULL,
  `user_no` int DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `ad_no` int DEFAULT NULL,
  `dep0/with1` tinyint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (123,1500,'2021-11-21 22:39:08',123,0),(1500,1500,'2021-11-21 22:42:27',1500,0),(1500,1500,'2021-11-21 22:47:26',1500,1),(10000,1500,'2021-11-21 22:47:40',10000,0);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfer`
--

DROP TABLE IF EXISTS `transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfer` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `date` varchar(45) NOT NULL,
  `amount` int NOT NULL,
  `time_out` int NOT NULL,
  `reciever_id` int NOT NULL,
  `sender_id` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3672381 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfer`
--

LOCK TABLES `transfer` WRITE;
/*!40000 ALTER TABLE `transfer` DISABLE KEYS */;
INSERT INTO `transfer` VALUES (8484,'12772021',50,10,1282,2321),(3672372,'12772021',78282,10,1282,2321),(3672373,'2021-11-15',200,10,267292,11820706),(3672374,'2021-11-15',200,10,267292,11820706),(3672375,'2021-11-30',500,10,267292,11820706),(3672376,'2021-11-20',100,10,267292,11820706),(3672377,'2021-11-20',100,10,267292,11820706),(3672378,'2021-11-20',100,10,267292,11820706),(3672379,'2021-11-20',100,10,267292,11820706),(3672380,'2021-11-20',300,10,267292,11820706);
/*!40000 ALTER TABLE `transfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `SSN` int NOT NULL,
  `Fname` varchar(45) NOT NULL,
  `Lname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `birthdate` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `zip_code` int NOT NULL,
  `verification_password` varchar(45) NOT NULL,
  `BankID` int NOT NULL,
  `CCN` varchar(45) NOT NULL,
  `blocking` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`SSN`),
  UNIQUE KEY `BankID_UNIQUE` (`BankID`),
  UNIQUE KEY `CCN_UNIQUE` (`CCN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'','','ezz','1234','10-9-2000','ee','ee','ee',12,'ss',1500,'22',1,10623),(1617,'Mohammad','Ahmad','mohammad','22','2021-11-17','ahmad277@gmail.com','Palestine','Jerusalem',11,'123',272892,'1111',0,1000),(2221,'ahmad','helal','ahmad_helal','11','2021-11-09','ahmed@gmail.com','Palestine','Jerusalem',1212,'11',11223,'1212',0,2890),(26271,'Mohammad','Ahmad','mohmammad_ahmad','1234','2021-11-17','mhammad1999@gmail.com','Palestine','Nablus',171,'12',11820945,'11',0,8900),(33321,'Ahmad','sameer','ahamd_user','11','2021-11-02','ahmad_ahmad','Palestine','Nablus',11,'11',11,'112',0,1111),(52618,'Ameer','Yaish','ameer_yaish','1234','2000-04-23','ameer@gmail.com','Palestine','Nablus',1670,'1234',267292,'123',0,9600),(406812701,'Ezz Addin','Kukhun','ezz_addin_kukhun','12','2000-09-10','ezkukhun2000@gmail.com','Palestine','Nablus',1234,'11',11820706,'1234',0,100);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-21 22:54:33
