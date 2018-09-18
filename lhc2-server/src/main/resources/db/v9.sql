--liquibase formatted sql

--changeset lhc2:9

CREATE TABLE `seqyz` (
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
	`w9` int(11) NOT NULL,
	`w10` int(11) NOT NULL,
	`w11` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `seqzf` (
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
	`zf9` int(11) NOT NULL,
	`zf10` int(11) NOT NULL,
	`zf11` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `seqsw` (
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
	`sw10` int(11) NOT NULL,
	`sw11` int(11) NOT NULL,
	`sw12` int(11) NOT NULL,
	`sw1pos` int(11) NOT NULL,
	`sw2pos` int(11) NOT NULL,
	`sw3pos` int(11) NOT NULL,
	`sw4pos` int(11) NOT NULL,
	`sw5pos` int(11) NOT NULL,
	`sw6pos` int(11) NOT NULL,
	`sw7pos` int(11) NOT NULL,
	`sw8pos` int(11) NOT NULL,
	`sw9pos` int(11) NOT NULL,
	`sw10pos` int(11) NOT NULL,
	`sw11pos` int(11) NOT NULL,
	`sw12pos` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);