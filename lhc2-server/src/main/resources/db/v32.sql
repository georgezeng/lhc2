--liquibase formatted sql

--changeset lhc2:32

CREATE TABLE `lhc3_system_config` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`key` varchar(50) NOT NULL,
	`value` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `lhc3_tm` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`num` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);