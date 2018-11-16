--liquibase formatted sql

--changeset lhc2:22

CREATE TABLE `dxds1yz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`small` int(11) NOT NULL,
	`large` int(11) NOT NULL,
	`odd` int(11) NOT NULL,
	`even` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `dxds2yz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`small_odd` int(11) NOT NULL,
	`small_even` int(11) NOT NULL,
	`large_odd` int(11) NOT NULL,
	`large_even` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `dxds2zf` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`zf0` int(11) NOT NULL,
	`zf1` int(11) NOT NULL,
	`zf2` int(11) NOT NULL,
	`zf3` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);

