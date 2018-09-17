--liquibase formatted sql

--changeset lhc2:1

CREATE TABLE `tm` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`sx` varchar(5) NOT NULL,
	PRIMARY KEY (`id`)
);
