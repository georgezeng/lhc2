--liquibase formatted sql

--changeset lhc2:17

CREATE TABLE `pick_num` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`expected` int(11) NOT NULL,
	`payload` text NOT NULL,
	PRIMARY KEY (`id`)
);
