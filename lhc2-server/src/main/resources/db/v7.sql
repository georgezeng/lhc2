--liquibase formatted sql

--changeset lhc2:7

CREATE TABLE `zsyz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`w0` int(11) NOT NULL,
	`w1` int(11) NOT NULL,
	`w2` int(11) NOT NULL,
	`w3` int(11) NOT NULL,
	`w4` int(11) NOT NULL,
	`w5` int(11) NOT NULL,
	`w6` int(11) NOT NULL,
	`w7` int(11) NOT NULL,
	`w8` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `zszf` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`zf0` int(11) NOT NULL,
	`zf1` int(11) NOT NULL,
	`zf2` int(11) NOT NULL,
	`zf3` int(11) NOT NULL,
	`zf4` int(11) NOT NULL,
	`zf5` int(11) NOT NULL,
	`zf6` int(11) NOT NULL,
	`zf7` int(11) NOT NULL,
	`zf8` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `zssw` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`sw1` int(11) NOT NULL,
	`sw2` int(11) NOT NULL,
	`sw3` int(11) NOT NULL,
	`sw4` int(11) NOT NULL,
	`sw5` int(11) NOT NULL,
	`sw6` int(11) NOT NULL,
	`sw7` int(11) NOT NULL,
	`sw8` int(11) NOT NULL,
	`sw9` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);