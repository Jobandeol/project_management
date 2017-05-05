-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2017 at 06:41 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_mangement`
--

-- --------------------------------------------------------

--
-- Table structure for table `project_details`
--

CREATE TABLE `project_details` (
  `P_id` int(4) NOT NULL,
  `Title` varchar(20) NOT NULL,
  `Description` varchar(20) NOT NULL,
  `U_id` int(4) DEFAULT NULL,
  `start_date` date NOT NULL,
  `due_date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_details`
--

INSERT INTO `project_details` (`P_id`, `Title`, `Description`, `U_id`, `start_date`, `due_date`) VALUES
(2, 'Demo', 'Go', NULL, '2017-03-12', '2017-03-15'),
(3, 'demo 1', 'Go 1', 1, '2017-03-13', '2017-03-17'),
(4, 'Demo 2', 'Go 3', 1, '2017-03-14', '2017-03-17'),
(5, 'J1', 'Ok', 5, '2017-03-17', '2017-03-25'),
(6, 'blood', 'keerda', 1, '2017-03-20', '2017-03-25'),
(7, 'Demo3', 'Check', 1, '2017-03-20', '2017-03-21'),
(8, 'mijithya', 'chitta', 1, '2017-03-21', '2017-03-23'),
(9, 'demo new', 'dwscription', 5, '2017-03-22', '2017-03-26'),
(10, 'demo4', 'abc', 1, '2017-03-25', '2017-03-26'),
(11, 'C1', 'Call', 10, '2017-03-25', '2017-03-26'),
(12, 'Demo4', 'test', 22, '2017-03-28', '2017-03-29'),
(13, 'demo10', 'Error', 5, '2017-04-02', '2017-04-03');

-- --------------------------------------------------------

--
-- Table structure for table `project_members`
--

CREATE TABLE `project_members` (
  `id` int(11) NOT NULL,
  `member_email` varchar(30) NOT NULL,
  `project_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_members`
--

INSERT INTO `project_members` (`id`, `member_email`, `project_id`) VALUES
(1, 'w', 3),
(2, 'jd.taira100@gmail.com', 3),
(3, 'jd.taira100@gmail.com', 3),
(4, 'w', 6),
(5, 'ABc', 12),
(6, 'ssnt35@gmail.com', 5);

-- --------------------------------------------------------

--
-- Table structure for table `project_progress_details`
--

CREATE TABLE `project_progress_details` (
  `Id` int(4) NOT NULL,
  `P_id` int(4) NOT NULL,
  `Percentage_progress` int(4) NOT NULL,
  `Completion` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tasks_details`
--

CREATE TABLE `tasks_details` (
  `T_id` int(4) NOT NULL,
  `P_id` int(4) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Deadline` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `task_discussion_details`
--

CREATE TABLE `task_discussion_details` (
  `Id` int(4) NOT NULL,
  `T_id` int(4) NOT NULL,
  `U_id` int(4) NOT NULL,
  `Message` varchar(50) NOT NULL,
  `Date` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `U_id` int(4) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Mobile` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`U_id`, `Name`, `Email`, `Password`, `Mobile`) VALUES
(1, NULL, 'w', '1', NULL),
(2, NULL, 'wgsgcg xv', '1', NULL),
(3, NULL, '', '', NULL),
(4, NULL, 'jfghy', 'rt', NULL),
(5, NULL, 'jd.taira100@gmail.com', '1', NULL),
(6, NULL, 'jdinception12@gmail.com', '12', NULL),
(7, NULL, 'jd....100@gmail.com', '123', NULL),
(8, NULL, 'Raju', '123', NULL),
(9, NULL, 'A', '123', NULL),
(10, NULL, 'Cyrus', '321', NULL),
(11, NULL, 'Cyrus', '321', NULL),
(12, NULL, 'we', '12', NULL),
(13, NULL, 'we', '321', NULL),
(14, NULL, 'ABc', '123', NULL),
(15, NULL, '', '', NULL),
(16, NULL, '', '', NULL),
(17, NULL, 'satbir333@gmail.com', '123', NULL),
(18, NULL, 'satbir333@gmail.com', '123', NULL),
(19, NULL, 'satbir333@gmail.com', '123', NULL),
(20, NULL, 'satbir333@gmail.com', '123', NULL),
(21, NULL, 'ssnt35@gmail.com', 'qwer', NULL),
(22, NULL, 'jd.taira100@gmail.com', '12', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_tasks_details`
--

CREATE TABLE `user_tasks_details` (
  `Id` int(4) NOT NULL,
  `U_id` int(4) NOT NULL,
  `T_id` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `project_details`
--
ALTER TABLE `project_details`
  ADD PRIMARY KEY (`P_id`);

--
-- Indexes for table `project_members`
--
ALTER TABLE `project_members`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `project_progress_details`
--
ALTER TABLE `project_progress_details`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tasks_details`
--
ALTER TABLE `tasks_details`
  ADD PRIMARY KEY (`T_id`);

--
-- Indexes for table `task_discussion_details`
--
ALTER TABLE `task_discussion_details`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`U_id`);

--
-- Indexes for table `user_tasks_details`
--
ALTER TABLE `user_tasks_details`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `project_details`
--
ALTER TABLE `project_details`
  MODIFY `P_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `project_members`
--
ALTER TABLE `project_members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `U_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
