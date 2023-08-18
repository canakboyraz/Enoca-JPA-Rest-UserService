-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 18 Ağu 2023, 08:43:00
-- Sunucu sürümü: 10.4.27-MariaDB
-- PHP Sürümü: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `enoca`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `company`
--

CREATE TABLE `company` (
  `company_id` bigint(20) NOT NULL,
  `company_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `company`
--

INSERT INTO `company` (`company_id`, `company_name`) VALUES
(1, 'Enoca'),
(2, 'Enoca-SAP'),
(3, 'Enoca-SAP-Hybris');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `person`
--

CREATE TABLE `person` (
  `person_id` bigint(20) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `person`
--

INSERT INTO `person` (`person_id`, `department`, `name`, `surname`) VALUES
(1, 'IT', 'Can', 'Akboyraz'),
(2, 'IT', 'Ayşenur', 'Akboyraz'),
(5, 'IT', 'Burak', 'Özer'),
(6, 'IT', 'Burak', 'Özer'),
(7, 'IT', 'Buket', 'Özer'),
(8, 'IT', 'Burrrr', 'Akboyraz'),
(9, 'IT', 'Buket', 'Akboyraz');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `person_person_company`
--

CREATE TABLE `person_person_company` (
  `person_person_id` bigint(20) NOT NULL,
  `person_company_company_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `person_person_company`
--

INSERT INTO `person_person_company` (`person_person_id`, `person_company_company_id`) VALUES
(8, 1),
(9, 1),
(6, 1),
(7, 2),
(5, 2),
(1, 2),
(2, 1);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`company_id`);

--
-- Tablo için indeksler `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`person_id`);

--
-- Tablo için indeksler `person_person_company`
--
ALTER TABLE `person_person_company`
  ADD KEY `FKs3fjmpyjk8d2rhd4tkgtsgk7l` (`person_company_company_id`),
  ADD KEY `FKgtkltiqcxyi4ydrl26161t8gp` (`person_person_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `company`
--
ALTER TABLE `company`
  MODIFY `company_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `person`
--
ALTER TABLE `person`
  MODIFY `person_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `person_person_company`
--
ALTER TABLE `person_person_company`
  ADD CONSTRAINT `FKgtkltiqcxyi4ydrl26161t8gp` FOREIGN KEY (`person_person_id`) REFERENCES `person` (`person_id`),
  ADD CONSTRAINT `FKs3fjmpyjk8d2rhd4tkgtsgk7l` FOREIGN KEY (`person_company_company_id`) REFERENCES `company` (`company_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
