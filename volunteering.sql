-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 12, 2016 at 08:07 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `volunteering`
--

-- --------------------------------------------------------

--
-- Table structure for table `beneficiary`
--

CREATE TABLE `beneficiary` (
  `beneficiaryID` int(11) NOT NULL,
  `projectID` int(11) NOT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `imgID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE `image` (
  `imgID` int(15) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `projectID` int(11) NOT NULL,
  `createdBy` int(11) NOT NULL,
  `description` int(11) DEFAULT NULL,
  `expectedStartDate` date DEFAULT NULL,
  `expectedEndDate` date DEFAULT NULL,
  `status` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `resource`
--

CREATE TABLE `resource` (
  `resourceID` int(11) NOT NULL,
  `name` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `taskID` int(11) NOT NULL,
  `projectID` int(11) NOT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `status` int(11) DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `assignedTo` int(11) DEFAULT NULL,
  `resourceID` int(11) DEFAULT NULL,
  `imgID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `task_beneficiary`
--

CREATE TABLE `task_beneficiary` (
  `id` int(11) NOT NULL,
  `taskID` int(11) NOT NULL,
  `beneficiaryID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `roleID` int(11) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(4) DEFAULT '1',
  `fullname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `gender` int(1) UNSIGNED DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(500) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `roleID` int(11) NOT NULL,
  `role` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`roleID`, `role`) VALUES
(1, 'ADMIN'),
(3, 'VOLUNTEER');

-- --------------------------------------------------------

--
-- Table structure for table `volunteer_offer`
--

CREATE TABLE `volunteer_offer` (
  `offerID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `taskID` int(11) NOT NULL,
  `service` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `beneficiary`
--
ALTER TABLE `beneficiary`
  ADD PRIMARY KEY (`beneficiaryID`),
  ADD KEY `imgID` (`imgID`),
  ADD KEY `imgID_2` (`imgID`),
  ADD KEY `projectID` (`projectID`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`imgID`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`projectID`),
  ADD KEY `ceatedBy` (`createdBy`);

--
-- Indexes for table `resource`
--
ALTER TABLE `resource`
  ADD PRIMARY KEY (`resourceID`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`taskID`),
  ADD KEY `assignedTo` (`assignedTo`),
  ADD KEY `projectID` (`projectID`),
  ADD KEY `imgID` (`imgID`),
  ADD KEY `resource` (`resourceID`);

--
-- Indexes for table `task_beneficiary`
--
ALTER TABLE `task_beneficiary`
  ADD PRIMARY KEY (`id`),
  ADD KEY `taskID` (`taskID`),
  ADD KEY `beneficiaryID` (`beneficiaryID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`),
  ADD UNIQUE KEY `userid` (`userid`),
  ADD UNIQUE KEY `userid_2` (`userid`),
  ADD KEY `roleID` (`roleID`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`roleID`);

--
-- Indexes for table `volunteer_offer`
--
ALTER TABLE `volunteer_offer`
  ADD PRIMARY KEY (`offerID`),
  ADD KEY `userID` (`userID`),
  ADD KEY `taskID` (`taskID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `beneficiary`
--
ALTER TABLE `beneficiary`
  MODIFY `beneficiaryID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `image`
--
ALTER TABLE `image`
  MODIFY `imgID` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;
--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `projectID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `resource`
--
ALTER TABLE `resource`
  MODIFY `resourceID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `taskID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `task_beneficiary`
--
ALTER TABLE `task_beneficiary`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `roleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `volunteer_offer`
--
ALTER TABLE `volunteer_offer`
  MODIFY `offerID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `beneficiary`
--
ALTER TABLE `beneficiary`
  ADD CONSTRAINT `beneficiary_ibfk_1` FOREIGN KEY (`imgID`) REFERENCES `image` (`imgID`);

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`createdBy`) REFERENCES `user` (`userid`);

--
-- Constraints for table `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `task_ibfk_1` FOREIGN KEY (`imgID`) REFERENCES `image` (`imgID`),
  ADD CONSTRAINT `task_ibfk_2` FOREIGN KEY (`assignedTo`) REFERENCES `user` (`userid`),
  ADD CONSTRAINT `task_ibfk_3` FOREIGN KEY (`projectID`) REFERENCES `project` (`projectID`),
  ADD CONSTRAINT `task_ibfk_4` FOREIGN KEY (`resourceID`) REFERENCES `resource` (`resourceID`);

--
-- Constraints for table `task_beneficiary`
--
ALTER TABLE `task_beneficiary`
  ADD CONSTRAINT `task_beneficiary_ibfk_1` FOREIGN KEY (`taskID`) REFERENCES `task` (`taskID`),
  ADD CONSTRAINT `task_beneficiary_ibfk_2` FOREIGN KEY (`beneficiaryID`) REFERENCES `beneficiary` (`beneficiaryID`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleID`) REFERENCES `user_role` (`roleID`);

--
-- Constraints for table `volunteer_offer`
--
ALTER TABLE `volunteer_offer`
  ADD CONSTRAINT `volunteer_offer_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userid`),
  ADD CONSTRAINT `volunteer_offer_ibfk_2` FOREIGN KEY (`taskID`) REFERENCES `task` (`taskID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
