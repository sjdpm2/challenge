-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.16 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para challenge_database
CREATE DATABASE IF NOT EXISTS `challenge_database` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `challenge_database`;

-- Volcando estructura para tabla challenge_database.candidate
CREATE TABLE IF NOT EXISTS `candidate` (
  `ca_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ca_first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ca_last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ca_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ca_id_document` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ca_ct_id` bigint(20) NOT NULL,
  `ca_de_id` bigint(20) DEFAULT NULL,
  `ca_votes` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ca_id`),
  KEY `ca_ct_id_fk` (`ca_ct_id`),
  KEY `ca_de_id_fk` (`ca_de_id`),
  CONSTRAINT `ca_ct_id_fk` FOREIGN KEY (`ca_ct_id`) REFERENCES `committee` (`ct_id`),
  CONSTRAINT `ca_de_id_fk` FOREIGN KEY (`ca_de_id`) REFERENCES `department` (`de_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla challenge_database.candidate: ~18 rows (aproximadamente)
DELETE FROM `candidate`;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` (`ca_id`, `ca_first_name`, `ca_last_name`, `ca_email`, `ca_id_document`, `ca_ct_id`, `ca_de_id`, `ca_votes`) VALUES
	(1, 'Luis', 'Perez', 'luis.perez@email.com', '12332144', 1, 1, 1),
	(2, 'Rodolfo', 'Salvatore', 'rodolfo.salvatore@email.com', '34566545', 1, 1, 0),
	(3, 'Marta', 'Gutierrez', 'marta.gutierrez@email.com', '23423447', 2, 2, 0),
	(4, 'Erik', 'Lozano', 'erik.lozano@email.com', '09098767', 2, 2, 0),
	(5, 'Augusto', 'Paz', 'augusto.paz@email.com', '48573348', 3, 3, 0),
	(6, 'Adolfo', 'Salamanca', 'adolfo.salamanca@email.com', '22838383', 3, 3, 0),
	(7, 'Octavio', 'Pereira', 'octavio.pereira@email.com', '88877773', 4, 4, 0),
	(8, 'Margarita', 'Lainez', 'margarita.lainez@email.com', '34343434', 4, 4, 0),
	(9, 'Luisa', 'Laine', 'luisa.laine@email.com', '54545454', 5, 5, 0),
	(10, 'Karen', 'Sosa', 'karen.sosa@email.com', '65656565', 5, 5, 0),
	(11, 'Mario', 'Gomez', 'mario.gomez@email.com', '67676767', 6, 6, 0),
	(12, 'Susana', 'Aries', 'susana.aries@email.com', '98776655', 6, 6, 0),
	(13, 'Rigoberto', 'Medrano', 'rigoberto.medrano@email.com', '65656444', 7, 7, 0),
	(14, 'Ricardo', 'Lopez', 'ricardo.lopez@email.com', '34345677', 7, 7, 0),
	(15, 'Sandra', 'Rivas', 'sandra.rivas@email.com', '45456778', 8, 8, 0),
	(16, 'Luis', 'Ponce', 'luis.ponce@email.com', '86322222', 8, 8, 0),
	(17, 'Sonia', 'Merino', 'sonia.merino@email.com', '21212121', 9, 9, 0),
	(18, 'Esteban', 'Figueroa', 'esteban.figueroa@email.com', '32323232', 9, 9, 0);
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;

-- Volcando estructura para tabla challenge_database.committee
CREATE TABLE IF NOT EXISTS `committee` (
  `ct_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ct_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ct_co_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ct_id`),
  KEY `ct_co_id_fk` (`ct_co_id`),
  CONSTRAINT `ct_co_id_fk` FOREIGN KEY (`ct_co_id`) REFERENCES `country` (`co_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla challenge_database.committee: ~9 rows (aproximadamente)
DELETE FROM `committee`;
/*!40000 ALTER TABLE `committee` DISABLE KEYS */;
INSERT INTO `committee` (`ct_id`, `ct_name`, `ct_co_id`) VALUES
	(1, 'Committee SV 1', 1),
	(2, 'Committee GT 2', 2),
	(3, 'Committee HN 3', 3),
	(4, 'Committee SV 2', 1),
	(5, 'Committee SV 3', 1),
	(6, 'Committee GT 1', 2),
	(7, 'Committee GT 3', 2),
	(8, 'Committee HN 1', 3),
	(9, 'Committee HN 2', 3);
/*!40000 ALTER TABLE `committee` ENABLE KEYS */;

-- Volcando estructura para tabla challenge_database.country
CREATE TABLE IF NOT EXISTS `country` (
  `co_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `co_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`co_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla challenge_database.country: ~3 rows (aproximadamente)
DELETE FROM `country`;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`co_id`, `co_name`) VALUES
	(1, 'El Salvador'),
	(2, 'Guatemala'),
	(3, 'Honduras');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;

-- Volcando estructura para tabla challenge_database.department
CREATE TABLE IF NOT EXISTS `department` (
  `de_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `de_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`de_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla challenge_database.department: ~9 rows (aproximadamente)
DELETE FROM `department`;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`de_id`, `de_name`) VALUES
	(1, 'Department 1'),
	(2, 'Department 2'),
	(3, 'Department 3'),
	(4, 'Department 4'),
	(5, 'Department 5'),
	(6, 'Department 6'),
	(7, 'Department 7'),
	(8, 'Department 8'),
	(9, 'Department 9');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Volcando estructura para tabla challenge_database.role
CREATE TABLE IF NOT EXISTS `role` (
  `ro_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ro_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla challenge_database.role: ~6 rows (aproximadamente)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`ro_id`, `ro_name`) VALUES
	(1, 'ROLE_USER'),
	(2, 'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Volcando estructura para tabla challenge_database.user
CREATE TABLE IF NOT EXISTS `user` (
  `us_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `us_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `us_first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `us_last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `us_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `us_co_id` bigint(20) NOT NULL,
  PRIMARY KEY (`us_id`),
  UNIQUE KEY `us_email_key` (`us_email`),
  UNIQUE KEY `UKouhj3ffbx90ik9hhqs0d22sla` (`us_email`),
  KEY `us_co_id_fk` (`us_co_id`),
  CONSTRAINT `us_co_id_fk` FOREIGN KEY (`us_co_id`) REFERENCES `country` (`co_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla challenge_database.user: ~6 rows (aproximadamente)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`us_id`, `us_email`, `us_first_name`, `us_last_name`, `us_password`, `us_co_id`) VALUES
	(1, 'rodrigo.mejia@mail.com', 'Rodrigo', 'Mejia', '$2a$10$4StlRY4HjOrBPHAeTJCqD.VMLw3MXfPFFEDTl4lselObufeiaOabq', 1),
	(2, 'ivan.reyes@mail.com', 'Ivan', 'Reyes', '$2a$10$/0a/q40vfGSI3QPN8SGQG.WRfdWs7rVifP0IACtCpWClmIBBHM2Wa', 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Volcando estructura para tabla challenge_database.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `ur_us_id` bigint(20) NOT NULL,
  `ur_ro_id` bigint(20) NOT NULL,
  KEY `ro_id_key` (`ur_ro_id`),
  KEY `us_id_key` (`ur_us_id`),
  CONSTRAINT `ur_ro_id_fk` FOREIGN KEY (`ur_ro_id`) REFERENCES `role` (`ro_id`),
  CONSTRAINT `ur_us_id_fk` FOREIGN KEY (`ur_us_id`) REFERENCES `user` (`us_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla challenge_database.users_roles: ~6 rows (aproximadamente)
DELETE FROM `users_roles`;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`ur_us_id`, `ur_ro_id`) VALUES
	(1, 1),
	(2, 1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;

-- Volcando estructura para tabla challenge_database.user_committee
CREATE TABLE IF NOT EXISTS `user_committee` (
  `uc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uc_ct_id` bigint(20) NOT NULL,
  `uc_us_id` bigint(20) NOT NULL,
  `uc_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uc_id`),
  KEY `uc_ct_id_fk` (`uc_ct_id`),
  KEY `uc_us_id_fk` (`uc_us_id`),
  CONSTRAINT `uc_ct_id_fk` FOREIGN KEY (`uc_ct_id`) REFERENCES `committee` (`ct_id`),
  CONSTRAINT `uc_us_id_fk` FOREIGN KEY (`uc_us_id`) REFERENCES `user` (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla challenge_database.user_committee: ~0 rows (aproximadamente)
DELETE FROM `user_committee`;
/*!40000 ALTER TABLE `user_committee` DISABLE KEYS */;
INSERT INTO `user_committee` (`uc_id`, `uc_ct_id`, `uc_us_id`, `uc_date`) VALUES
	(1, 1, 1, '2019-11-27 19:40:12');
/*!40000 ALTER TABLE `user_committee` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
