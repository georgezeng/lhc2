--liquibase formatted sql

--changeset lhc2:52

CREATE TABLE `lhc3_pick_num` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`type` varchar(50) NOT NULL,
	`num` int(11) NOT NULL,
	`expected` int(11) NOT NULL,
	`payload` text NOT NULL,
	`time0` varchar(255) NOT NULL,
	`time1` varchar(255) NOT NULL,
	`time2` varchar(255) NOT NULL,
	`time2plus` varchar(255) NOT NULL,
	`time3plus` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `lhc3_color_yz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`tables` varchar(50) NOT NULL,
	`type` varchar(50) NOT NULL,
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
	`wr_color` varchar(20) NOT NULL,
	`wr` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `lhc3_color_yz_2` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`tables` varchar(50) NOT NULL,
	`type` varchar(50) NOT NULL,
	`wr` int(11) NOT NULL,
	`wr_pos` int(11) NOT NULL,
	`wr_base` int(11) NOT NULL,
	`wr_color` varchar(50) NOT NULL,
	`yzr` int(11) NOT NULL,
	`yzr_pos` int(11) NOT NULL,
	`yzr_base` int(11) NOT NULL,
	`yzr_color` varchar(50) NOT NULL,
	`yzg` int(11) NOT NULL,
	`yzg_pos` int(11) NOT NULL,
	`yzg_base` int(11) NOT NULL,
	`yzg_color` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `lhc3_times_yz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`type` varchar(50) NOT NULL,
	`tables` varchar(50) NOT NULL,
	`time03plus` int(11) NOT NULL,
	`time12` int(11) NOT NULL,
	`time2plus` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);
