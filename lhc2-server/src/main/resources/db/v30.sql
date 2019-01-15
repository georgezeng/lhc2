--liquibase formatted sql

--changeset lhc2:30

CREATE TABLE `color_yz_2` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`tables` varchar(50) NOT NULL,
	`type` varchar(50) NOT NULL,
	`wr` int(11) NOT NULL,
	`wr_pos` int(11) NOT NULL,
	`wr_color` varchar(50) NOT NULL,
	`yzr` int(11) NOT NULL,
	`yzr_pos` int(11) NOT NULL,
	`yzr_color` varchar(50) NOT NULL,
	`yzg` int(11) NOT NULL,
	`yzg_pos` int(11) NOT NULL,
	`yzg_color` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);
