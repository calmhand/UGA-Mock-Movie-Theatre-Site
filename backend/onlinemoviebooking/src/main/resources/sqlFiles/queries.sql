
/*creating database*/

CREATE DATABASE  IF NOT EXISTS `online_movie_booking_db`;
USE `online_movie_booking_db`;


/*status table*/

DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `statusid` int unsigned NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


LOCK TABLES `status` WRITE;
INSERT INTO `status` VALUES (1,"ACTIVE"),(2,"INACTIVE"),(3,"SUSPEND");
UNLOCK TABLES;


/*user table*/

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `number` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `issubscribed` boolean,
  `address` varchar(500) NOT NULL,
  `usertype` varchar(50) NOT NULL,
  `statusid` int unsigned NOT NULL, 
  PRIMARY KEY (`userid`),
  FOREIGN KEY (`statusid`) REFERENCES `status`(`statusid`),
  CONSTRAINT uc_email UNIQUE (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*paymentcard table*/

DROP TABLE IF EXISTS `paymentcard`;

CREATE TABLE `paymentcard` (
  `cardid` int unsigned NOT NULL AUTO_INCREMENT,
  `userid` int unsigned NOT NULL,
  `cardnumber` varchar(500) NOT NULL,
  `cardexpiry` varchar(500) NOT NULL,
  `billingaddress` varchar(500),
  PRIMARY KEY (`cardid`),
  FOREIGN KEY (`userid`) REFERENCES user(`userid`) ON DELETE CASCADE,
  CONSTRAINT uc_card_user UNIQUE (cardid,userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `movieid` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `rating` char(255) NOT NULL COMMENT 'MPAA-US film rating code: G, PG, PG-13, R',
  `release_date` date NOT NULL,
  `director` varchar(255) NOT NULL,
  `producer` varchar(255) NOT NULL,
  `cast` varchar(1000) NOT NULL,
  `synopsis` varchar(1000) NOT NULL,
  `poster_url` varchar(255)  COMMENT 'poster image link',
  `trailer_url` varchar(255) COMMENT 'trailer video link',
   PRIMARY KEY (`movieid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `promotion`;

CREATE TABLE `promotion` (
  `promoid` int unsigned NOT NULL AUTO_INCREMENT,
  `promotion_name` varchar(250) NOT NULL,
  `promocode` varchar(100) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `is_sent` boolean,
  `discount` float NOT NULL COMMENT 'percent discount',
  PRIMARY KEY (`promoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `showroom`;

CREATE TABLE `showroom` (
  `showroomid` int unsigned NOT NULL AUTO_INCREMENT,
  `showroom_name` char(250) NOT NULL,
  `seats` int unsigned NOT NULL,
  PRIMARY KEY (`showroomid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `showroom` WRITE;
INSERT INTO `showroom` VALUES (1,"SCREEN-X", 48),(2,"MAX-RELAX", 48),(3,"REAL-3D", 48), (4,"SCREEN-PLAY",48);
UNLOCK TABLES;


DROP TABLE IF EXISTS `showtime`;

CREATE TABLE `showtime` (
  `showid` int unsigned NOT NULL AUTO_INCREMENT,
  `movieid` int unsigned NOT NULL COMMENT 'movie being played',
  `showroomid` int unsigned NOT NULL COMMENT 'showroom of show (which hall)',
  `show_date` date NOT NULL COMMENT 'date of show',
  `show_timeslot` int unsigned NOT NULL COMMENT 'slot of show, lets keep 4 slots: 1(9:00 am),2(1:00 pm ),3(6:00pm),4(10:00pm)',
  PRIMARY KEY (`showid`),
  FOREIGN KEY (`movieid`) REFERENCES `movie`(`movieid`) ON DELETE CASCADE,
  FOREIGN KEY (`showroomid`) REFERENCES `showroom`(`showroomid`) ON DELETE CASCADE,
  CONSTRAINT uc_showroom_date_slot UNIQUE (showroomid,show_date,show_timeslot)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;













