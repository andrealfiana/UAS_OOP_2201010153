-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2024 at 06:03 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dataonepiece`
--

-- --------------------------------------------------------

--
-- Table structure for table `dataonepiece`
--

CREATE TABLE `dataonepiece` (
  `idkru` int(11) NOT NULL,
  `nama` varchar(225) DEFAULT NULL,
  `umur` varchar(225) DEFAULT NULL,
  `asal` varchar(122) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dataonepiece`
--

INSERT INTO `dataonepiece` (`idkru`, `nama`, `umur`, `asal`) VALUES
(1, 'Monkey D Luffy', 'Brazil', '19'),
(2, 'Roronoa Zoro', 'Jepang', '19'),
(3, 'Jinbie', 'Afrika', '46'),
(4, 'Sanji', 'Perancis', '19'),
(5, 'Franky', 'Amerika', '20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dataonepiece`
--
ALTER TABLE `dataonepiece`
  ADD PRIMARY KEY (`idkru`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dataonepiece`
--
ALTER TABLE `dataonepiece`
  MODIFY `idkru` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
