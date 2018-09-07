--liquibase formatted sql

--changeset lhc2:1

CREATE TABLE `tm` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(20) NOT NULL,
	`num` varchar(5) NOT NULL,
	`sx` varchar(5) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `idx_tm_phase` (`phase`),
	INDEX `idx_tm_num` (`num`),
	INDEX `idx_tm_sx` (`sx`)
);
