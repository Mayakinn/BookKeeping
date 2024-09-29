-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `isbn` int NOT NULL,
  `rating` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  CONSTRAINT `books_chk_1` CHECK (((`rating` >= 0) and (`rating` <= 5))),
  CONSTRAINT `books_chk_2` CHECK (((`year` >= 1000) and (`year` <= 2024)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES ('Garlic Is As Good As Ten Mothers','Osbourne Mattheeuw',1002,2,2006),('Crossworlds','Alphard Ewles',1037,5,2005),('Witless Protection','Wylie Wanka',1044,1,1999),('Catfish','Bernice Breewood',1055,2,1993),('Honey Moon (Honigmond)','Dorey Cardnell',1069,3,1987),('Bikes vs Cars','Chaddie Hubane',1081,4,2001),('Thank You, Jeeves!','Ronalda Cholerton',1116,5,2005),('Die Hard','Aubrie Presley',1126,3,2006),('Green Light','Patricio Pidgeley',1133,2,2005),('Decade Under the Influence, A','Dorette Pache',1166,1,2011),('Captive (Cautiva) ','Daphne Hambridge',1167,3,2006),('New Orleans Uncensored','Frayda Baythrop',1168,2,2010),('Flowing (Nagareru)','Lorianna Aldine',1203,1,2001),('Strange One, The','Kathie Deener',1205,3,2000),('Women on the Verge of a Nervous Breakdown (Mujeres al borde de un ataque de nervios)','Isidor Timmins',1217,1,2004),('Escape from Suburbia: Beyond the American Dream','Tad Stiller',1256,3,2002),('Skeleton Man','Kermy Edgeworth',1263,2,2010),('Children of Paradise (Les enfants du paradis)','Isabella Dupree',1293,4,2011),('Sliver','Olvan Blaxter',1297,4,1996),('Thurgood','Fritz Whickman',1301,5,2004),('Infection (Kansen)','Melisse Whewell',1338,5,2007),('Other Dream Team, The','Johan Scotchmoor',1343,3,1988),('Butley','Marie-ann Gamell',1365,3,1986),('Three (a.k.a. 3)','Jarred Shier',1407,2,2000),('Supermarket Woman (Sûpâ no onna)','Helaine Flowith',1430,4,2012),('Lucía, Lucía (Hija del caníbal, La)','Skipp Gerrans',1433,3,2001),('Shanghai Kiss','Ambrosi Beeckx',1519,5,2002),('Wheel of Time','Henka Tallach',1521,2,1997),('A Star Athlete','Agustin Crownshaw',1591,5,1993),('Pigsty (Porcile)','Rochella de Leon',1602,2,2012),('Paris Was a Woman','Joaquin Winson',1604,4,2006),('Sleepers','Demetra Edgeley',1627,4,2008),('Mary, Queen of Scots','Taber Matantsev',1663,4,2002),('Blackthorn','Derrik Sandes',1668,4,1992),('City of Sadness, A (Bei qing cheng shi)','Marty Jedrysik',1669,4,2010),('Who\'s Your Daddy?','Zea McQuilkin',1685,4,1991),('Spring','Kiele Lawtey',1687,5,1964),('Down Periscope','Loralyn Reddick',1704,5,2005),('Puppet Master 5: The Final Chapter','Gilemette Nibloe',1705,5,1995),('To Gillian on Her 37th Birthday','Phineas Bake',1714,4,2006),('Tiger and the Snow, The (La tigre e la neve)','Cad Divisek',1716,5,2005),('Just Looking','Wolfy Szimon',1728,1,2005),('Confidence','Salem Trayton',1741,5,2008),('Island of the Burning Damned (Night of the Big Heat)','Nelli Leedal',1747,1,2007),('The White Sister','Jillie Camelli',1766,2,2011),('North Country','Ansel Blemen',1803,4,1992),('Baxter, The','Rosalia Gowlett',1815,3,1989),('Kids in America','Lorilyn Button',1843,3,2011),('American Dreamz','Rutherford Cotta',1890,4,1994),('Birthday Girl','Taite Parysowna',1910,5,1995),('Page of Madness, A (Kurutta ippêji)','Bili Bradwell',1932,3,2007),('Dorian Gray','Chiquita Clynmans',1941,3,1969),('Touch of Zen, A (Xia nu)','Eadith Stote',1969,3,1995),('Mark Shoots First','Mohandis Van der Daal',1984,3,2004),('The Great Gatsby','F. Scott Fitzgerald',123456789,5,1925),('To Kill a Mockingbird','Harper Lee',987654321,4,1960);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-29 18:30:20
