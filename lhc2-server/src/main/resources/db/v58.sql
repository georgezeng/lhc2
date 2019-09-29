--liquibase formatted sql

--changeset lhc2:58

DROP TABLE `lhc3_times_yz`;

CREATE TABLE `lhc3_times_yz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`type` varchar(50) NOT NULL,
	`tables` varchar(50) NOT NULL,
	`num` int(11) NOT NULL,
	`time0` int(11) NOT NULL,
	`time1` int(11) NOT NULL,
	`time2` int(11) NOT NULL,
	`time3plus` int(11) NOT NULL,
	`time1plus` int(11) NOT NULL,
	`lt0` int(11) NOT NULL,
	`lt1` int(11) NOT NULL,
	`lt2` int(11) NOT NULL,
	`lt3plus` int(11) NOT NULL,
	`lt1plus` int(11) NOT NULL,
	`t0` int(11) NOT NULL,
	`t1` int(11) NOT NULL,
	`t2` int(11) NOT NULL,
	`t3plus` int(11) NOT NULL,
	`t1plus` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);
