-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: training_app
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `exercises`
--

DROP TABLE IF EXISTS `exercises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercises` (
  `exercise_id` int NOT NULL AUTO_INCREMENT,
  `exercise_name` varchar(100) NOT NULL,
  `muscle_group` varchar(50) DEFAULT NULL,
  `description` text,
  `tips` text,
  PRIMARY KEY (`exercise_id`),
  UNIQUE KEY `exercise_name` (`exercise_name`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercises`
--

LOCK TABLES `exercises` WRITE;
/*!40000 ALTER TABLE `exercises` DISABLE KEYS */;
INSERT INTO `exercises` VALUES (1,'Bench Press','Chest','Göğüs kaslarını, ön omuzu ve arka kolu çalıştıran temel serbest ağırlık itiş egzersizi.','Barı indirirken dirseklerini 45 derecelik açıda tut, kürek kemiklerini sehpaya sabitle ve ayaklarından güç al.'),(3,'Shoulder Press','Shoulders',NULL,NULL),(4,'Barbell Curl','Arms','Biceps (ön kol) kaslarını büyütmek için kullanılan, halter barı ile yapılan temel kıvırma hareketi.','Dirseklerini gövdene sabitle ve ileri geri oynatma. Sadece ön kolunu hareket ettir.'),(5,'Squat','Legs',NULL,NULL),(6,'Deadlift','Back',NULL,NULL),(7,'Leg Press','Legs',NULL,NULL),(8,'Pull Up','Back',NULL,NULL),(9,'Lat Pulldown','Back',NULL,NULL),(19,'Dumbbell Fly','Chest',NULL,NULL),(20,'Cable Crossover','Chest','Göğüs kaslarının iç ve alt kısmını hedefleyen, kablo istasyonunda yapılan sıkıştırma hareketi.','Kollarını tamamen kitlemeden hafif bükülü tut. Hareketi kollarınla değil, göğsünü sıkarak (sarılıyormuş gibi) yap.'),(21,'Decline Bench Press','Chest',NULL,NULL),(23,'Push Up','Chest',NULL,NULL),(24,'Chest Dips','Chest','Vücut ağırlığıyla yapılan, özellikle alt göğüs ve triceps kaslarını hedefleyen paralel bar itiş hareketi.','Göğse odaklanmak için gövdeni hafifçe öne eğ. İnerken omuz sağlığın için 90 derecelik dirsek açısını geçme.'),(25,'Seated Cable Row','Back',NULL,NULL),(26,'T-Bar Row','Back',NULL,NULL),(27,'Single Arm Dumbbell Row','Back',NULL,NULL),(28,'Straight Arm Pulldown','Back',NULL,NULL),(29,'Face Pull','Back',NULL,NULL),(30,'Chin Up','Back','Avuç içlerinin sana baktığı, biceps ve sırt (lat) kaslarını çalıştıran barfiks varyasyonu.','Kendini yukarı çekerken göğsünü bara yaklaştırmaya çalış. Aşağı inerken yavaş ve kontrollü ol.'),(31,'Rack Pull','Back',NULL,NULL),(32,'Bulgarian Split Squat','Legs','Arka bacağın bir sehpaya dayandığı, ön bacağa (quadriceps ve glute) odaklanan tek bacaklı squat varyasyonu.','Dengen için karın kaslarını sıkı tut. Aşağı inerken öndeki dizinin ayak ucunu çok geçmemesine özen göster.'),(33,'Romanian Deadlift (RDL)','Legs',NULL,NULL),(34,'Leg Extension','Legs',NULL,NULL),(35,'Seated Leg Curl','Legs',NULL,NULL),(36,'Lying Leg Curl','Legs',NULL,NULL),(37,'Standing Calf Raise','Legs',NULL,NULL),(38,'Walking Lunges','Legs',NULL,NULL),(39,'Hack Squat','Legs',NULL,NULL),(40,'Barbell Hip Thrust','Legs','Glute (kalça) kaslarını maksimum seviyede izole eden ve güçlendiren, sırtın sehpaya dayalı olduğu itiş hareketi.','Tepe noktasında kalçanı sık ve 1-2 saniye bekle. Boynunu nötr pozisyonda tut, geriye yatırma.'),(41,'Dumbbell Lateral Raise','Shoulders',NULL,NULL),(42,'Cable Lateral Raise','Shoulders','Yan omuz (lateral deltoid) kaslarını kablonun sürekli gerilimi altında çalıştıran yana açış hareketi.','Kabloyu çekerken bileğini hafifçe öne eğ (sanki sürahiden su döküyormuş gibi) ve omuz hizasında durdur.'),(43,'Front Raise','Shoulders',NULL,NULL),(44,'Reverse Pec Deck','Shoulders',NULL,NULL),(45,'Arnold Press','Shoulders','Omuz kaslarının üç başını da çalıştıran, dambılların döndürülerek yukarı itildiği omuz pres varyasyonu.','Başlangıçta avuç içleri yüzüne bakmalı, tepeye iterken dışarı dönmeli. Hareketi yavaş ve kontrollü yap.'),(46,'Upright Row','Shoulders',NULL,NULL),(47,'Dumbbell Shrugs','Shoulders',NULL,NULL),(48,'Tricep Rope Pushdown','Arms',NULL,NULL),(49,'Overhead Tricep Extension','Arms',NULL,NULL),(50,'Skull Crusher','Arms',NULL,NULL),(51,'Hammer Curl','Arms',NULL,NULL),(52,'Preacher Curl','Arms',NULL,NULL),(53,'Concentration Curl','Arms','Biceps kasının zirve (peak) noktasını hedefleyen, dirseğin bacağa dayandığı dambıl curl hareketi.','Dirseğini bacağının iç kısmına sabitle ve vücudundan momentum almadan sadece kas gücüyle kaldır.'),(54,'EZ Bar Curl','Arms',NULL,NULL),(55,'Crunches','Core','Karın (rectus abdominis) kaslarını çalıştıran temel ve klasik mekik hareketi.','Boynunu ellerinle öne doğru çekme, çeneni göğsünden uzak tut. Hareketi karın kaslarını sıkarak başlat.'),(56,'Plank','Core',NULL,NULL),(57,'Russian Twist','Core',NULL,NULL),(58,'Hanging Leg Raise','Core',NULL,NULL),(59,'Ab Wheel Rollout','Core','Karın kaslarını (core) yoğun bir şekilde çalıştıran, ab wheel tekerleği ile ileri doğru uzanılıp geri dönülen egzersiz.','Hareketi yaparken belini çukurlaştırma, karın kaslarını sürekli sıkı tut ve hareketin kontrolünü kaybetme.'),(60,'Cable Woodchopper','Core','Oblik (yan karın) kaslarını çalıştıran, kablo ile çapraz odun kırma simülasyonu hareketi.','Hareketi kollarınla değil, gövdeni (core) döndürerek yap. Kalçanı olabildiğince sabit tutmaya çalış.'),(61,'Chest Press Machine','Chest','Göğüs kaslarını izole eden, makine yardımıyla daha güvenli ve dengeli yapılan temel itiş hareketi.','Makinenin tutamakları göğsünün orta hizasına gelmeli. İterken göğsünü iyice sık.'),(62,'Dumbbell Shoulder Press','Shoulders',NULL,NULL),(63,'Dips Machine','Arms',NULL,NULL),(70,'Lat Pull Down','Back',NULL,NULL),(72,'Cable Rear Delt Fly','Back','Arka omuz (posterior deltoid) kaslarını hedefleyen, kablo istasyonunda çapraz çekiş hareketi.','Kollarını geriye çekerken kürek kemiklerini sıkıştır. Dirseklerini yüksekte tutmaya gayret et.'),(73,'Rope Hammer Curl','Arms',NULL,NULL),(74,'Scott Curl','Arms',NULL,NULL),(75,'Incline Dumbbell Press','Chest',NULL,NULL),(76,'Pec Deck Fly','Chest',NULL,NULL),(77,'Dumbbell Row','Back',NULL,NULL),(78,'Dumbbell Curl','Arm',NULL,NULL);
/*!40000 ALTER TABLE `exercises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routine_exercises`
--

DROP TABLE IF EXISTS `routine_exercises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routine_exercises` (
  `id` int NOT NULL AUTO_INCREMENT,
  `routine_id` int DEFAULT NULL,
  `exercise_name` varchar(100) NOT NULL,
  `default_sets` int DEFAULT '3',
  `default_reps` int DEFAULT '10',
  PRIMARY KEY (`id`),
  KEY `routine_id` (`routine_id`),
  CONSTRAINT `routine_exercises_ibfk_1` FOREIGN KEY (`routine_id`) REFERENCES `routines` (`routine_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routine_exercises`
--

LOCK TABLES `routine_exercises` WRITE;
/*!40000 ALTER TABLE `routine_exercises` DISABLE KEYS */;
INSERT INTO `routine_exercises` VALUES (1,1,'Bench Press',4,10),(2,1,'Incline Dumbbell Press',3,12),(3,1,'Triceps Pushdown',3,15);
/*!40000 ALTER TABLE `routine_exercises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routines`
--

DROP TABLE IF EXISTS `routines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routines` (
  `routine_id` int NOT NULL AUTO_INCREMENT,
  `routine_name` varchar(50) NOT NULL,
  PRIMARY KEY (`routine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routines`
--

LOCK TABLES `routines` WRITE;
/*!40000 ALTER TABLE `routines` DISABLE KEYS */;
INSERT INTO `routines` VALUES (1,'PUSH');
/*!40000 ALTER TABLE `routines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplement_log`
--

DROP TABLE IF EXISTS `supplement_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplement_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `log_date` date DEFAULT NULL,
  `whey_taken` tinyint(1) DEFAULT NULL,
  `creatine_taken` tinyint(1) DEFAULT NULL,
  `vit_d_taken` tinyint(1) DEFAULT NULL,
  `fish_oil_taken` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplement_log`
--

LOCK TABLES `supplement_log` WRITE;
/*!40000 ALTER TABLE `supplement_log` DISABLE KEYS */;
INSERT INTO `supplement_log` VALUES (1,'2026-09-09',1,0,0,0),(2,'2026-10-04',1,1,0,0);
/*!40000 ALTER TABLE `supplement_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_details`
--

DROP TABLE IF EXISTS `workout_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_details` (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `session_id` int NOT NULL,
  `exercise_name` varchar(100) NOT NULL,
  `set_number` int NOT NULL,
  `reps` int NOT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `session_id` (`session_id`),
  CONSTRAINT `workout_details_ibfk_1` FOREIGN KEY (`session_id`) REFERENCES `workout_sessions` (`session_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_details`
--

LOCK TABLES `workout_details` WRITE;
/*!40000 ALTER TABLE `workout_details` DISABLE KEYS */;
INSERT INTO `workout_details` VALUES (1,4,'Bench',2,10,50),(2,8,'Bench',2,10,40),(3,9,'Bench',2,10,50),(4,10,'sdcwf',2,4,40),(5,11,'fwa',5,4,10),(6,14,'fggrerges',2,3,45),(7,15,'munuymy',8,9,6),(8,18,'Bench Press',1,5,50),(9,18,'Bench Press',2,7,42),(10,18,'Incline Dumbbell Press',1,7,42),(11,18,'Incline Dumbbell Press',2,7,42),(12,25,'Incline Dumbbell Press',1,6,45),(13,26,'Barbell Curl',1,8,40),(14,26,'Bench Press',1,2,40),(15,27,'Bench Press',1,6,50),(16,30,'Arnold Press',1,10,15),(17,49,'Chest Press Machine',1,7,25),(18,49,'Chest Press Machine',2,6,25),(19,49,'Pec Deck Fly',1,10,45),(20,49,'Pec Deck Fly',2,8,45),(21,49,'Incline Dumbbell Press',1,10,12.5),(22,49,'Incline Dumbbell Press',2,9,12.5),(23,49,'Dumbbell Shoulder Press',1,10,7.5),(24,49,'Dumbbell Shoulder Press',2,10,7.5),(25,49,'Dumbbell Lateral Raise',1,8,7.5),(26,49,'Dumbbell Lateral Raise',2,8,7.5),(27,49,'Tricep Rope Pushdown',1,10,35),(28,49,'Tricep Rope Pushdown',2,10,35);
/*!40000 ALTER TABLE `workout_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_sessions`
--

DROP TABLE IF EXISTS `workout_sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_sessions` (
  `session_id` int NOT NULL AUTO_INCREMENT,
  `log_date` date NOT NULL,
  `workout_type` varchar(50) NOT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_sessions`
--

LOCK TABLES `workout_sessions` WRITE;
/*!40000 ALTER TABLE `workout_sessions` DISABLE KEYS */;
INSERT INTO `workout_sessions` VALUES (1,'2026-09-22','PUSH'),(2,'2026-09-22','PUSH'),(3,'2026-09-22','PUSH'),(4,'2026-09-22','PUSH'),(5,'2026-09-22','PUSH'),(6,'2026-09-22','PUSH'),(7,'2026-09-22','PUSH'),(8,'2026-09-22','PUSH'),(9,'2026-09-22','PUSH'),(10,'2026-09-23','PUSH'),(11,'2026-09-22','PUSH'),(12,'2026-09-22','PUSH'),(13,'2026-09-04','PULL'),(14,'2026-09-03','PUSH'),(15,'2026-10-02','PUSH'),(16,'2026-10-04','PUSH'),(17,'2026-10-03','PUSH'),(18,'2026-10-04','PUSH'),(19,'2026-10-10','PULL'),(20,'2026-10-09','PUSH'),(21,'2026-10-15','PUSH'),(22,'2026-10-11','PULL'),(23,'2026-10-10','PULL'),(24,'2026-10-10','PULL'),(25,'2026-10-17','PULL'),(26,'2026-10-09','PULL'),(27,'2026-10-10','PULL'),(28,'2026-10-03','PULL'),(29,'2026-10-11','FULL BODY'),(30,'2026-10-11','PULL'),(31,'2026-10-10','PUSH'),(32,'2026-10-18','PULL'),(33,'2026-10-24','PULL'),(34,'2026-10-22','PUSH'),(35,'2026-10-22','PUSH'),(36,'2026-10-22','PUSH'),(37,'2026-10-22','PUSH'),(38,'2026-10-10','PUSH'),(39,'2026-10-13','PUSH'),(40,'2026-10-22','PUSH'),(41,'2026-10-13','PUSH'),(42,'2026-10-18','PUSH'),(43,'2026-10-13','PUSH'),(44,'2026-10-13','PUSH'),(45,'2026-10-13','PUSH'),(46,'2026-10-13','PUSH'),(47,'2026-10-13','PUSH'),(48,'2026-10-13','PUSH'),(49,'2026-10-14','PUSH'),(50,'2026-10-13','PUSH');
/*!40000 ALTER TABLE `workout_sessions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-21  0:13:16
