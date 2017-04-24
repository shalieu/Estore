/*
SQLyog Ultimate v8.55 
MySQL - 5.6.14 : Database - estoredb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`estoredb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `estoredb`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `auId` int(10) NOT NULL AUTO_INCREMENT,
  `auFirstName` varchar(50) NOT NULL,
  `auLastName` varchar(50) NOT NULL,
  PRIMARY KEY (`auId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `author` */

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bookId` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `imgContent` blob NOT NULL,
  `categoryId` int(10) NOT NULL,
  `publisherId` int(10) NOT NULL,
  `reOrderLevel` int(10) NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

/*Table structure for table `book1` */

DROP TABLE IF EXISTS `book1`;

CREATE TABLE `book1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `isbn` varchar(25) NOT NULL,
  `sellingPrice` decimal(25,0) NOT NULL,
  `addedDate` date NOT NULL,
  `reOrderLevel` int(25) NOT NULL,
  `stockInHand` int(25) NOT NULL,
  `typeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book1` (`typeId`),
  CONSTRAINT `FK_book1` FOREIGN KEY (`typeId`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `book1` */

insert  into `book1`(`id`,`title`,`isbn`,`sellingPrice`,`addedDate`,`reOrderLevel`,`stockInHand`,`typeId`) values (1,'Amma','978-955-21-2583-6','650','2017-03-05',5,10,1),(2,'Kaliyugaya','978-955-21-2583-7','400','2017-03-10',5,10,1),(3,'Viragaya','978-955-21-2583-8','400','2017-03-12',5,10,2),(4,'Rathu Rosa Mala','978-955-21-2583-9','800','2017-03-15',5,10,2),(5,'Guru Geethaya','978-955-21-2583-10','85','2017-03-20',5,10,3),(6,'Gilunu Sanda Madala','978-955-21-2583-11','100','2017-03-20',5,10,4);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`categoryName`) values (1,'Action'),(3,'Romantic'),(2,'Tragedy');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `salary` int(11) NOT NULL,
  `totSalary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`name`,`salary`,`totSalary`) values (1,'Amal',15000,0),(2,'Ruwan',20000,0),(3,'Sahan',8000,0),(4,'Chamila',8000,0);

/*Table structure for table `estore_role` */

DROP TABLE IF EXISTS `estore_role`;

CREATE TABLE `estore_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userEmail` varchar(64) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_estore_role` (`userEmail`),
  CONSTRAINT `FK_estore_role` FOREIGN KEY (`userEmail`) REFERENCES `estore_user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `estore_role` */

insert  into `estore_role`(`id`,`userEmail`,`roleId`) values (1,'shalika@gmail.com',2),(2,'amila@gmail.com',1);

/*Table structure for table `estore_user` */

DROP TABLE IF EXISTS `estore_user`;

CREATE TABLE `estore_user` (
  `email` varchar(64) NOT NULL,
  `firstName` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `registeredDate` date NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estore_user` */

insert  into `estore_user`(`email`,`firstName`,`lastName`,`registeredDate`,`password`) values ('amila@gmail.com','Amila','Sampath','2017-02-02','abc123'),('shalika@gmail.com','Shalika','Madhuwanthi','2017-02-02','abc123');

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_movie` (`categoryId`),
  CONSTRAINT `FK_movie` FOREIGN KEY (`categoryId`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `movie` */

insert  into `movie`(`id`,`name`,`categoryId`) values (1,'Sky',1),(2,'Maya',1),(3,'Bee',1),(4,'HithaHoda Pisso',2),(5,'RJ',2),(6,'flowers of L',3);

/*Table structure for table `profit` */

DROP TABLE IF EXISTS `profit`;

CREATE TABLE `profit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(50) NOT NULL,
  `netProfit` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `profit` */

insert  into `profit`(`id`,`month`,`netProfit`) values (1,'Jan',12000),(2,'Feb',13000),(3,'Mar',15000),(4,'Apr',16000);

/*Table structure for table `publisher` */

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `pubId` int(10) NOT NULL AUTO_INCREMENT,
  `pubName` varchar(50) NOT NULL,
  `emailAdd` varchar(50) NOT NULL,
  `contactNo` varchar(10) NOT NULL,
  `pubAddress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pubId`),
  UNIQUE KEY `NewIndex1` (`pubName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `publisher` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `regDate` date NOT NULL,
  `age` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`firstName`,`lastName`,`regDate`,`age`) values (1,'Sanduni','Paba','0000-00-00',24),(2,'Piumi','Madhushika','2017-03-18',18),(3,'Kumara','Madhushanka','2017-03-18',24),(4,'Suranga','Nisansala','2017-03-18',12),(5,'Udara','Sankalpa','2017-03-18',24);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `regNo` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`regNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`id`,`typeName`) values (1,'Sinhala Novel'),(2,'Sinhala Short Stories'),(3,'Translations Novel'),(4,'Translations Short Stories');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
