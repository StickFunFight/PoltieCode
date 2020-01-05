-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 05 jan 2020 om 23:38
-- Serverversie: 10.1.30-MariaDB
-- PHP-versie: 7.1.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `politiecode`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `bekeuring`
--

CREATE TABLE `bekeuring` (
  `Id` int(11) NOT NULL,
  `Kenteken` varchar(50) NOT NULL,
  `Reden` varchar(50) NOT NULL,
  `Datum` varchar(50) NOT NULL,
  `MedewerkerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `bekeuring`
--

INSERT INTO `bekeuring` (`Id`, `Kenteken`, `Reden`, `Datum`, `MedewerkerId`) VALUES
(1, '70LKKD', '', '01/03/2020 4:24:13 PM', 1),
(2, 'GB001B', 'test', '01/03/2020 4:25:15 PM', 1),
(3, '70LKKD', 'test', '01/03/2020 4:26:05 PM', 1),
(4, '70LKKD', 'test', '01/03/2020 4:26:22 PM', 2),
(5, 'GB001B', 'test', '01/03/2020 4:29:11 PM', 1);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `medewerker`
--

CREATE TABLE `medewerker` (
  `Id` int(11) NOT NULL,
  `Naam` varchar(50) NOT NULL,
  `Wachtwoord` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `medewerker`
--

INSERT INTO `medewerker` (`Id`, `Naam`, `Wachtwoord`) VALUES
(1, 'Rick', 'Rick'),
(2, 'Sjaak', 'Sjaak');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `voertuig`
--

CREATE TABLE `voertuig` (
  `Kenteken` varchar(10) NOT NULL,
  `Voertuigsoort` varchar(50) NOT NULL,
  `Merk` varchar(50) NOT NULL,
  `Handelsbenaming` varchar(50) NOT NULL,
  `Eerste_kleur` varchar(15) NOT NULL,
  `Tweede_kleur` varchar(50) DEFAULT NULL,
  `Vervaldatum_apk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `voertuig`
--

INSERT INTO `voertuig` (`Kenteken`, `Voertuigsoort`, `Merk`, `Handelsbenaming`, `Eerste_kleur`, `Tweede_kleur`, `Vervaldatum_apk`) VALUES
('70LKKD', 'Personenauto', 'PEUGEOT', '206', 'GRIJS', 'Niet geregistreerd', '20200927');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `bekeuring`
--
ALTER TABLE `bekeuring`
  ADD PRIMARY KEY (`Id`);

--
-- Indexen voor tabel `medewerker`
--
ALTER TABLE `medewerker`
  ADD PRIMARY KEY (`Id`);

--
-- Indexen voor tabel `voertuig`
--
ALTER TABLE `voertuig`
  ADD PRIMARY KEY (`Kenteken`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `bekeuring`
--
ALTER TABLE `bekeuring`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT voor een tabel `medewerker`
--
ALTER TABLE `medewerker`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
