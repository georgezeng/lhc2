--liquibase formatted sql

--changeset lhc2:55

CREATE TABLE `analyze_yz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`tm` int(11) NOT NULL,
	`expected` int(11) NOT NULL,
	`type` varchar(50) NOT NULL,
	`yz0` int(11) NOT NULL,
	`yz1p` int(11) NOT NULL,
	`yz0light` int(11) NOT NULL,
	`yz1p_light` int(11) NOT NULL,
	`nums0` int(11) NOT NULL,
	`nums0avg` int(11) NOT NULL,
	`nums1p` int(11) NOT NULL,
	`nums1p_avg` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);
