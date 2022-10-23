-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 23, 2022 at 05:45 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinema_booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `Booking`
--

CREATE TABLE `Booking` (
  `BookingID` int(11) NOT NULL,
  `customerID` int(11) NOT NULL,
  `showID` int(11) NOT NULL,
  `total` float NOT NULL COMMENT 'Total price of tickets',
  `paymentID` int(11) NOT NULL,
  `promoID` int(11) NOT NULL,
  `shippingAddress` varchar(255) NOT NULL,
  `dateOfPurchase` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Movie`
--

CREATE TABLE `Movie` (
  `movieID` int(11) NOT NULL,
  `cast` varchar(1000) NOT NULL,
  `category` char(255) NOT NULL,
  `title` char(255) NOT NULL,
  `director` char(255) NOT NULL,
  `producer` char(255) NOT NULL,
  `synopsis` varchar(1000) NOT NULL,
  `reviews` varchar(1000) NOT NULL,
  `poster` varchar(255) NOT NULL COMMENT 'poster image link',
  `trailer` varchar(255) NOT NULL COMMENT 'trailer video link',
  `rating` char(255) NOT NULL COMMENT 'MPAA-US film rating code'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `PaymentCard`
--

CREATE TABLE `PaymentCard` (
  `cardID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `cardNo` bigint(20) NOT NULL,
  `cardExp` date NOT NULL,
  `CVV` int(11) NOT NULL,
  `billingAddress` varchar(255) NOT NULL,
  `cardType` char(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Promotion`
--

CREATE TABLE `Promotion` (
  `promoID` int(11) NOT NULL,
  `pCode` char(255) NOT NULL,
  `start` date NOT NULL,
  `end` date NOT NULL,
  `discount` float NOT NULL COMMENT 'percent discount'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `SeatInShow`
--

CREATE TABLE `SeatInShow` (
  `seatID` int(11) NOT NULL,
  `showID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Showroom`
--

CREATE TABLE `Showroom` (
  `showroomID` int(11) NOT NULL,
  `name` char(255) NOT NULL,
  `noOfSeats` int(11) NOT NULL,
  `is3D` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Showtime`
--

CREATE TABLE `Showtime` (
  `showID` int(11) NOT NULL,
  `movieID` int(11) NOT NULL COMMENT 'movie being played',
  `showroomID` int(11) NOT NULL COMMENT 'location of showing (which hall)',
  `date` datetime NOT NULL COMMENT 'date and time of showing'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Status`
--

CREATE TABLE `Status` (
  `statusID` int(11) NOT NULL,
  `status` char(255) NOT NULL COMMENT 'Active or Suspended'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `Ticket`
--

CREATE TABLE `Ticket` (
  `ticketNo` int(11) NOT NULL,
  `typeID` int(11) NOT NULL COMMENT 'Adult, Child, or Senior',
  `bookingID` int(11) NOT NULL,
  `seatID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `TicketType`
--

CREATE TABLE `TicketType` (
  `ticketTypeID` int(11) NOT NULL,
  `type` char(255) NOT NULL COMMENT 'Adult, Child, or Senior',
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `userID` int(11) NOT NULL,
  `firstName` char(255) NOT NULL,
  `lastName` char(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `email` char(255) NOT NULL,
  `password` char(255) NOT NULL,
  `promoOpt` tinyint(1) NOT NULL COMMENT 'Opt in or out of receiving promotions through email',
  `statusID` int(11) NOT NULL,
  `userType` char(255) NOT NULL COMMENT 'Admin or Customer',
  `shipAddress` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Booking`
--
ALTER TABLE `Booking`
  ADD PRIMARY KEY (`BookingID`);

--
-- Indexes for table `Movie`
--
ALTER TABLE `Movie`
  ADD PRIMARY KEY (`movieID`);

--
-- Indexes for table `PaymentCard`
--
ALTER TABLE `PaymentCard`
  ADD PRIMARY KEY (`cardID`);

--
-- Indexes for table `Promotion`
--
ALTER TABLE `Promotion`
  ADD PRIMARY KEY (`promoID`);

--
-- Indexes for table `SeatInShow`
--
ALTER TABLE `SeatInShow`
  ADD PRIMARY KEY (`seatID`);

--
-- Indexes for table `Showroom`
--
ALTER TABLE `Showroom`
  ADD PRIMARY KEY (`showroomID`);

--
-- Indexes for table `Showtime`
--
ALTER TABLE `Showtime`
  ADD PRIMARY KEY (`showID`);

--
-- Indexes for table `Status`
--
ALTER TABLE `Status`
  ADD PRIMARY KEY (`statusID`);

--
-- Indexes for table `Ticket`
--
ALTER TABLE `Ticket`
  ADD PRIMARY KEY (`ticketNo`);

--
-- Indexes for table `TicketType`
--
ALTER TABLE `TicketType`
  ADD PRIMARY KEY (`ticketTypeID`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Booking`
--
ALTER TABLE `Booking`
  MODIFY `BookingID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Movie`
--
ALTER TABLE `Movie`
  MODIFY `movieID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `PaymentCard`
--
ALTER TABLE `PaymentCard`
  MODIFY `cardID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Promotion`
--
ALTER TABLE `Promotion`
  MODIFY `promoID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `SeatInShow`
--
ALTER TABLE `SeatInShow`
  MODIFY `seatID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Showroom`
--
ALTER TABLE `Showroom`
  MODIFY `showroomID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Showtime`
--
ALTER TABLE `Showtime`
  MODIFY `showID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Status`
--
ALTER TABLE `Status`
  MODIFY `statusID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Ticket`
--
ALTER TABLE `Ticket`
  MODIFY `ticketNo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `TicketType`
--
ALTER TABLE `TicketType`
  MODIFY `ticketTypeID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
