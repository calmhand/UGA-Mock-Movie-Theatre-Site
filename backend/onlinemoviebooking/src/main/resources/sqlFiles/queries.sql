
/*creating database*/

CREATE DATABASE  IF NOT EXISTS `online_movie_booking_db`;
USE `online_movie_booking_db`;


/*status table*/

DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `statusid` int unsigned NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`statusid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


LOCK TABLES `status` WRITE;
INSERT INTO `status` VALUES (1,"ACTIVE"),(2,"INACTIVE"),(3,"DELETE");
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

