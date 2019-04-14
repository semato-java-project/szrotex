-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Kwi 2019, 10:51
-- Wersja serwera: 10.1.38-MariaDB
-- Wersja PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `szrotex`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `boat`
--

CREATE TABLE `boat` (
  `id` int(10) UNSIGNED NOT NULL,
  `displacement` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `car`
--

CREATE TABLE `car` (
  `id` int(10) UNSIGNED NOT NULL DEFAULT '2',
  `brand` varchar(255) CHARACTER SET utf8 NOT NULL,
  `model` varchar(255) CHARACTER SET utf8 NOT NULL,
  `engine_capacity` double UNSIGNED DEFAULT NULL,
  `engine_type` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `engine_power` int(10) UNSIGNED DEFAULT NULL,
  `production_year` int(4) UNSIGNED DEFAULT NULL,
  `doors_quantity` int(10) UNSIGNED DEFAULT NULL,
  `transsmision` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `seats_quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `car`
--

INSERT INTO `car` (`id`, `brand`, `model`, `engine_capacity`, `engine_type`, `engine_power`, `production_year`, `doors_quantity`, `transsmision`, `seats_quantity`) VALUES
(1, 'BMW', 'X5 ', 3, 'Diesel', 313, 2016, 5, 'auto', 5),
(2, 'Alfa Romeo', 'Stelvio', 2, 'Turbo', 280, 2017, 5, 'auto', 5),
(3, 'Audi', 'A7', 3, 'Diesel', 286, 2018, 5, 'auto', 5),
(4, 'Porsche', 'Cayenne', 4.8, 'Petrol', 400, 2015, 5, 'manual', 5),
(5, 'Porsche', '911 Targa 4', 3.8, 'Petrol', 350, 2014, 3, 'manual', 2),
(6, 'Mazda', 'CX-3', 2, 'Petrol', 150, 2017, 5, 'auto', 5),
(7, 'Mercedes Benz', 'SLS', 6.2, 'Petrol', 571, 2010, 3, 'manual', 2),
(8, 'Mercedes Benz', 'Klasa G', 6, 'Petrol', 630, 2018, 5, 'auto', 5),
(9, 'Mercedes Benz', 'GLK', 3, 'Diesel', 224, 2008, 5, 'auto', 5),
(10, 'Maserati', 'Granturismo', 4.7, 'Petrol', 460, 2017, 2, 'auto', 4),
(11, 'Lamborgihni', 'Aventador', 6.5, 'Petrol', 740, 2018, 2, 'auto', 2),
(12, 'Ferrari ', '458 Italia', 5, 'Petrol', 605, 2015, 2, 'auto', 2),
(13, 'Tesla', 'Model S', 4, 'Electric', 367, 2014, 5, 'auto', 5),
(14, 'Bentley', 'Continental GT', 6, 'Petrol', 635, 2015, 2, 'auto', 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `client`
--

CREATE TABLE `client` (
  `id` int(10) UNSIGNED NOT NULL,
  `created_at` date NOT NULL,
  `email` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `client`
--

INSERT INTO `client` (`id`, `created_at`, `email`, `first_name`, `last_name`, `phone`) VALUES
(1, '2019-04-13', 'maja.wasilewska@testgmail.com', 'Maja', 'Wasilewska', 844231079),
(2, '2019-04-13', 'damian.laskowski@testwp.pl', 'Damian', 'Laskowski', 454452444),
(3, '2019-04-13', 'oliwia.lewandowska@testonet.pl', 'Oliwia', 'Lewnadowska', 219856483),
(4, '2019-04-13', 'michalina.pawlik@testo2.pl', 'Michalina', 'Pawlik', 385863141),
(5, '2019-04-13', 'filip.jasinski@testwp.pl', 'Filip', 'Jasiński', 86301814),
(6, '2019-04-13', 'anna.wlodarczyk@testgmail.com', 'Anna', 'Włodarczyk', 229917576),
(7, '2019-04-13', 'maria.dudek@testwp.pl', 'Maria', 'Dudek', 499662235),
(8, '2019-04-13', 'karol.skowronski@testonet.pl', 'Karol', 'Skowroński', 875311434),
(9, '2019-04-13', 'lukasz.kaminski@test.com', 'Łukasz', 'Kamiński', 139045332),
(10, '2019-04-13', 'krzysztof.krawczyk@najlepszamuzyka.pl', 'Krzysztof', 'Krawczyk', 501423117);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(29);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reservation`
--

CREATE TABLE `reservation` (
  `id` int(10) UNSIGNED NOT NULL,
  `vehicle_id` int(10) UNSIGNED DEFAULT NULL,
  `client_id` int(10) UNSIGNED DEFAULT NULL,
  `date_start` datetime DEFAULT NULL,
  `date_end` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `id` int(10) UNSIGNED NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` char(32) NOT NULL,
  `salt` char(32) NOT NULL,
  `created_at` datetime NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `salt`, `created_at`, `first_name`, `last_name`) VALUES
(1, 'admin@example.com', '0a10553aa8f8a9b297ee7748b64bb346', '97c26f1cfc6b906947f73401bbaf26b2', '2019-03-24 19:21:43', 'admin', 'admin'),
(2, 'a', 'c336be70f95564207789b259dbdd79f0', 'c5a5193a6bfa98b7861cd9fe2eb49577', '2019-03-13 20:05:22', 'dev', 'dev');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `vehicle`
--

CREATE TABLE `vehicle` (
  `id` int(10) UNSIGNED NOT NULL,
  `price` decimal(10,2) UNSIGNED DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `link_to_img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `vehicle`
--

INSERT INTO `vehicle` (`id`, `price`, `color`, `link_to_img`) VALUES
(1, '230.00', 'black', 'src/main/resources/assets/cars/bmwx5.png'),
(2, '214.00', 'silver', 'src/main/resources/assets/cars/alfas.png'),
(3, '369.00', 'white', 'src/main/resources/assets/cars/audia7.png'),
(4, '250.00', 'black', 'src/main/resources/assets/cars/porschec.png'),
(5, '381.00', 'white', 'src/main/resources/assets/porschet.png'),
(6, '188.00', 'blue', 'src/main/resources/assets/mazdacx.png'),
(7, '499.00', 'grey', 'src/main/resources/assets/cars/mbs.png'),
(8, '554.00', 'black', 'src/main/resources/assets/cars/mbg.png'),
(9, '170.00', 'white', 'src/main/resources/assets/cars/mbg.png'),
(10, '388.00', 'blue', 'src/main/resources/assets/cars/maseratig.png'),
(11, '532.00', 'green', 'src/main/resources/assets/cars/lamborgihnia.png'),
(12, '444.00', 'red', 'src/main/resources/assets/cars/ferrarii.png'),
(13, '259.00', 'black', 'src/main/resources/assets/cars/teslas.png'),
(14, '421.00', 'orange', 'src/main/resources/assets/cars/bentleyc.png');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `boat`
--
ALTER TABLE `boat`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_reservation_1_idx` (`vehicle_id`),
  ADD KEY `fk_reservation_2_idx` (`client_id`);

--
-- Indeksy dla tabeli `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- Indeksy dla tabeli `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `boat`
--
ALTER TABLE `boat`
  ADD CONSTRAINT `FKh8f4yp5p3wk7x40cnii9rlfny` FOREIGN KEY (`id`) REFERENCES `vehicle` (`id`);

--
-- Ograniczenia dla tabeli `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `FKfugwdpykh9kb35q1quro44hrm` FOREIGN KEY (`id`) REFERENCES `vehicle` (`id`);

--
-- Ograniczenia dla tabeli `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FKkgohlqki8f2mklx7edyoq0l5f` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `FKrm327sr0rb11mme0kbsm37od5` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
