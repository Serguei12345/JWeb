-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 18 Décembre 2014 à 18:09
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `jweb`
--

-- --------------------------------------------------------

--
-- Structure de la table `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `news_id` int(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(16000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_author` int(255) NOT NULL,
  `visible` int(1) NOT NULL,
  `date` datetime(6) NOT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `news`
--

INSERT INTO `news` (`news_id`, `title`, `content`, `image`, `id_author`, `visible`, `date`) VALUES
(1, 'first news omagad', 'je suis le contenu de l''article bonjour', 'nope', 1, 1, '2014-12-18 00:00:00.000000');

-- --------------------------------------------------------

--
-- Structure de la table `shop`
--

CREATE TABLE IF NOT EXISTS `shop` (
  `shop_id` int(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(2048) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `visible` int(1) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `shop`
--

INSERT INTO `shop` (`shop_id`, `title`, `description`, `image`, `visible`, `price`) VALUES
(1, 'Figurine serguei collector', 'ceci est une figurine collector de serguei', 'lel', 1, 1000);

-- --------------------------------------------------------

--
-- Structure de la table `shop_review`
--

CREATE TABLE IF NOT EXISTS `shop_review` (
  `review_id` int(255) NOT NULL AUTO_INCREMENT,
  `id_author` int(255) NOT NULL,
  `review` varchar(2048) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime(6) NOT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(255) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `firstName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `subscribeNews` int(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `power` int(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`user_id`, `userName`, `email`, `firstName`, `lastName`, `subscribeNews`, `password`, `power`) VALUES
(1, 'admin', 'admin@jeanbon.com', 'jean', 'bon', 1, 'lel', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
