--liquibase formatted sql

--changeset lhc2:3

CREATE TABLE `swyz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`w0` int(11) NOT NULL,
	`w1` int(11) NOT NULL,
	`w2` int(11) NOT NULL,
	`w3` int(11) NOT NULL,
	`w4` int(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `idx_swyz_phase` (`phase`),
	INDEX `idx_swyz_num` (`num`)
);


CREATE TABLE `swzf` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`zf0` int(11) NOT NULL,
	`zf1` int(11) NOT NULL,
	`zf2` int(11) NOT NULL,
	`zf3` int(11) NOT NULL,
	`zf4` int(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `idx_swzf_phase` (`phase`),
	INDEX `idx_swzf_num` (`num`)
);

CREATE TABLE `swsw` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`sw1` int(11) NOT NULL,
	`sw2` int(11) NOT NULL,
	`sw3` int(11) NOT NULL,
	`sw4` int(11) NOT NULL,
	`sw5` int(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `idx_swsw_phase` (`phase`),
	INDEX `idx_swsw_num` (`num`)
);