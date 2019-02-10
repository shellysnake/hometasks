-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.46-log - MySQL Community Server (GPL)
-- Операционная система:         Win32
-- HeidiSQL Версия:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных shop_db
CREATE DATABASE IF NOT EXISTS `shop_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shop_db`;

-- Дамп структуры для таблица shop_db.category
CREATE TABLE IF NOT EXISTS `category` (
  `cat_name` varchar(50) NOT NULL,
  PRIMARY KEY (`cat_name`),
  UNIQUE KEY `cat_name` (`cat_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы shop_db.category: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`cat_name`) VALUES
	('Laptops'),
	('Tablets');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Дамп структуры для таблица shop_db.products
CREATE TABLE IF NOT EXISTS `products` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `prod_name` varchar(50) NOT NULL,
  `category_name` varchar(50) NOT NULL,
  `price` double NOT NULL DEFAULT '0',
  `rank` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `category_name` (`category_name`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_name`) REFERENCES `category` (`cat_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы shop_db.products: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id`, `prod_name`, `category_name`, `price`, `rank`) VALUES
	(1, 'Asus', 'Laptops', 2222.2, 5),
	(2, 'Asus2', 'Laptops', 2321.2, 3),
	(3, 'Tablet1', 'Tablets', 1111.1, 1),
	(4, 'Tablet2', 'Tablets', 1231.7, 2);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;

-- Дамп структуры для таблица shop_db.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(5) NOT NULL AUTO_INCREMENT,
  `user_login` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_login` (`user_login`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы shop_db.users: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `user_login`, `user_password`) VALUES
	(1, 'login123', 'password'),
	(2, 'log13221', 'qwertyuiop'),
	(3, 'testlog', 'qwertyu13iop'),
	(4, 'login555', 'password1332');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
