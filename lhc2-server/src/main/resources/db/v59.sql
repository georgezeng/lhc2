--liquibase formatted sql

--changeset lhc2:59

CREATE TABLE `lhc3_stake` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`type` varchar(50) NOT NULL,
	`num` int(11) NOT NULL,
	`current_amount` decimal(20, 2) NOT NULL,
	`history_amount` decimal(20, 2) NOT NULL,
	`last_bonus` decimal(20, 2) NOT NULL,
	`history_bonus` decimal(20, 2) NOT NULL,
	`time1` int(11) NOT NULL,
	`time2` int(11) NOT NULL,
	`time3` int(11) NOT NULL,
	`time4` int(11) NOT NULL,
	`time5` int(11) NOT NULL,
	`time6` int(11) NOT NULL,
	`time7` int(11) NOT NULL,
	`time8` int(11) NOT NULL,
	`time9` int(11) NOT NULL,
	`time10` int(11) NOT NULL,
	`time11` int(11) NOT NULL,
	`time12` int(11) NOT NULL,
	`time13` int(11) NOT NULL,
	`time14` int(11) NOT NULL,
	`time15` int(11) NOT NULL,
	`time16` int(11) NOT NULL,
	`time17` int(11) NOT NULL,
	`time18` int(11) NOT NULL,
	`time19` int(11) NOT NULL,
	`time20` int(11) NOT NULL,
	`time21` int(11) NOT NULL,
	`time22` int(11) NOT NULL,
	`time23` int(11) NOT NULL,
	`time24` int(11) NOT NULL,
	`time25` int(11) NOT NULL,
	`time26` int(11) NOT NULL,
	`time27` int(11) NOT NULL,
	`time28` int(11) NOT NULL,
	`time29` int(11) NOT NULL,
	`time30` int(11) NOT NULL,
	`time31` int(11) NOT NULL,
	`time32` int(11) NOT NULL,
	`time33` int(11) NOT NULL,
	`time34` int(11) NOT NULL,
	`time35` int(11) NOT NULL,
	`time36` int(11) NOT NULL,
	`time37` int(11) NOT NULL,
	`time38` int(11) NOT NULL,
	`time39` int(11) NOT NULL,
	`time40` int(11) NOT NULL,
	`time41` int(11) NOT NULL,
	`time42` int(11) NOT NULL,
	`time43` int(11) NOT NULL,
	`time44` int(11) NOT NULL,
	`time45` int(11) NOT NULL,
	`time46` int(11) NOT NULL,
	`time47` int(11) NOT NULL,
	`time48` int(11) NOT NULL,
	`time49` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);
