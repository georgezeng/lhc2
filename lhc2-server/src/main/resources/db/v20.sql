--liquibase formatted sql

--changeset lhc2:20

CREATE TABLE `times_yz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`tables` varchar(50) NOT NULL,
	`time0` int(11) NOT NULL,
	`time12` int(11) NOT NULL,
	`time3plus` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `color_yz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`tables` varchar(50) NOT NULL,
	`yz` int(11) NOT NULL,
	`yz_color` varchar(50) NOT NULL,
	`r1` int(11) NOT NULL,
	`r1color` varchar(50) NOT NULL,
	`r2` int(11) NOT NULL,
	`r2color` varchar(50) NOT NULL,
	`r3` int(11) NOT NULL,
	`r3color` varchar(50) NOT NULL,
	`r4` int(11) NOT NULL,
	`r4color` varchar(50) NOT NULL,
	`r5` int(11) NOT NULL,
	`r5color` varchar(50) NOT NULL,
	`g1` int(11) NOT NULL,
	`g1color` varchar(50) NOT NULL,
	`g2` int(11) NOT NULL,
	`g2color` varchar(50) NOT NULL,
	`g3` int(11) NOT NULL,
	`g3color` varchar(50) NOT NULL,
	`g4` int(11) NOT NULL,
	`g4color` varchar(50) NOT NULL,
	`g5` int(11) NOT NULL,
	`g5color` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);
