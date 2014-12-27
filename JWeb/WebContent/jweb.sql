-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Sam 27 Décembre 2014 à 23:05
-- Version du serveur: 5.1.53
-- Version de PHP: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `jweb`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE IF NOT EXISTS `article` (
  `id_article` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` text COLLATE utf8_bin NOT NULL,
  `text` text COLLATE utf8_bin NOT NULL,
  `image` text COLLATE utf8_bin NOT NULL,
  `date_edit` datetime NOT NULL,
  `id_author` bigint(20) NOT NULL,
  PRIMARY KEY (`id_article`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=7 ;

--
-- Contenu de la table `article`
--

INSERT INTO `article` (`id_article`, `title`, `text`, `image`, `date_edit`, `id_author`) VALUES
(1, 'test_1', 'texte test_1', 'texte image', '2014-12-22 16:28:22', 1),
(2, 'test_2', 'texte test_2', 'texte immage test_2', '2014-12-22 16:29:31', 2),
(3, 'test_3', 'texte test_3', 'texte image test_3', '2014-12-22 16:30:15', 1),
(4, 'Introduisez votre titre ici', 'Introduisez votre texte ici', 'lol', '2014-12-23 17:49:57', 1),
(5, 'Introduisez votre titre ici', 'Introduisez votre texte ici', 'image', '2014-12-26 19:36:53', 1),
(6, 'Introduisez votre titre ici', 'Introduisez votre texte ici', 'image', '2014-12-26 19:43:35', 1);

-- --------------------------------------------------------

--
-- Structure de la table `bought_products`
--

CREATE TABLE IF NOT EXISTS `bought_products` (
  `id_buy` int(11) NOT NULL AUTO_INCREMENT,
  `id_product` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date_bought` datetime NOT NULL,
  PRIMARY KEY (`id_buy`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=37 ;

--
-- Contenu de la table `bought_products`
--

INSERT INTO `bought_products` (`id_buy`, `id_product`, `id_user`, `date_bought`) VALUES
(2, 2, 1, '2014-12-27 23:59:14'),
(1, 3, 1, '2014-12-27 23:58:54');

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id_product` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` text COLLATE utf8_bin NOT NULL,
  `date_publication` datetime NOT NULL,
  `id_publisher` bigint(20) NOT NULL,
  `description` text COLLATE utf8_bin NOT NULL,
  `price` float NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- Contenu de la table `product`
--

INSERT INTO `product` (`id_product`, `name`, `date_publication`, `id_publisher`, `description`, `price`, `quantity`) VALUES
(1, 'product1', '2014-12-27 00:00:00', 1, 'description1', 10, 0),
(2, 'product2', '2014-12-27 00:00:00', 1, 'description2', 20, 57),
(3, 'lolcat', '2014-12-27 23:52:52', 1, 'lolstache', 5000, 4998);

-- --------------------------------------------------------

--
-- Structure de la table `review`
--

CREATE TABLE IF NOT EXISTS `review` (
  `id_review` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_author` bigint(20) NOT NULL,
  `title` text CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL,
  `text` text COLLATE utf8_bin NOT NULL,
  `image` text COLLATE utf8_bin NOT NULL,
  `id_product` bigint(20) NOT NULL,
  `date_edit` datetime NOT NULL,
  PRIMARY KEY (`id_review`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Contenu de la table `review`
--

INSERT INTO `review` (`id_review`, `id_author`, `title`, `text`, `image`, `id_product`, `date_edit`) VALUES
(1, 1, 'rProduit1', 'rProduit1', 'image', 1, '2014-12-27 00:09:00'),
(2, 1, 'rProduit2', 'rProduit2', 'image', 2, '2014-12-27 00:09:10');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` text COLLATE utf8_bin NOT NULL,
  `password` text COLLATE utf8_bin NOT NULL,
  `email` text COLLATE utf8_bin NOT NULL,
  `rights` text COLLATE utf8_bin NOT NULL,
  `last_connection` datetime NOT NULL,
  `is_connected` tinyint(1) NOT NULL,
  `credit` float NOT NULL,
  KEY `id_user` (`id_user`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id_user`, `login`, `password`, `email`, `rights`, `last_connection`, `is_connected`, `credit`) VALUES
(1, 'Serguei12345', 'Serge12345', 'serguei.ovoyan@epitech.eu', '11111', '2014-12-23 16:35:41', 1, 0),
(1, 'nono', 'a', 'nono@epitech.eu', '00000', '2014-12-23 16:36:54', 1, 0),
(1, 'test_1', 'test', 'test@epitech.eu', '11011', '2014-12-23 16:38:15', 1, 0),
(2, 'Serge12345', 'Serge12345', 'a@b.eu', '00000', '2014-12-27 21:21:25', 1, 0),
(2, 'a', 'b', 'c@@', '00000', '2014-12-27 21:21:42', 1, 0),
(2, 'Serge', 'a', 'c@d.eu', '00000', '2014-12-27 21:25:15', 1, 0),
(2, 'a1', 'b2', 'c3@epitech.eu', '00000', '2014-12-27 21:40:20', 1, 0);
