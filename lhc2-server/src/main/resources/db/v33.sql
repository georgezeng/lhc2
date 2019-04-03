--liquibase formatted sql

--changeset lhc2:33

CREATE TABLE `lhc3_seqa_yz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`total_cols_yz` int(11) NOT NULL,
	`r_cols_yz` int(11) NOT NULL,
	`max_col_yz` int(11) NOT NULL,
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
	`w12` int(11) NOT NULL,
	`lt1` int(11) NOT NULL,
	`lt2` int(11) NOT NULL,
	`lt3` int(11) NOT NULL,
	`lt4` int(11) NOT NULL,
	`lt5` int(11) NOT NULL,
	`lt6` int(11) NOT NULL,
	`lt7` int(11) NOT NULL,
	`lt8` int(11) NOT NULL,
	`lt9` int(11) NOT NULL,
	`lt10` int(11) NOT NULL,
	`lt11` int(11) NOT NULL,
	`lt12` int(11) NOT NULL,
	`t1` int(11) NOT NULL,
	`t2` int(11) NOT NULL,
	`t3` int(11) NOT NULL,
	`t4` int(11) NOT NULL,
	`t5` int(11) NOT NULL,
	`t6` int(11) NOT NULL,
	`t7` int(11) NOT NULL,
	`t8` int(11) NOT NULL,
	`t9` int(11) NOT NULL,
	`t10` int(11) NOT NULL,
	`t11` int(11) NOT NULL,
	`t12` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `lhc3_seqa_zf` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`total_cols_yz` int(11) NOT NULL,
	`r_cols_yz` int(11) NOT NULL,
	`max_col_yz` int(11) NOT NULL,
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
	`w12` int(11) NOT NULL,
	`lt1` int(11) NOT NULL,
	`lt2` int(11) NOT NULL,
	`lt3` int(11) NOT NULL,
	`lt4` int(11) NOT NULL,
	`lt5` int(11) NOT NULL,
	`lt6` int(11) NOT NULL,
	`lt7` int(11) NOT NULL,
	`lt8` int(11) NOT NULL,
	`lt9` int(11) NOT NULL,
	`lt10` int(11) NOT NULL,
	`lt11` int(11) NOT NULL,
	`lt12` int(11) NOT NULL,
	`t1` int(11) NOT NULL,
	`t2` int(11) NOT NULL,
	`t3` int(11) NOT NULL,
	`t4` int(11) NOT NULL,
	`t5` int(11) NOT NULL,
	`t6` int(11) NOT NULL,
	`t7` int(11) NOT NULL,
	`t8` int(11) NOT NULL,
	`t9` int(11) NOT NULL,
	`t10` int(11) NOT NULL,
	`t11` int(11) NOT NULL,
	`t12` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `lhc3_seqa_sw` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` varchar(50) NOT NULL,
	`num` int(11) NOT NULL,
	`pos` int(11) NOT NULL,
	`total_cols_yz` int(11) NOT NULL,
	`r_cols_yz` int(11) NOT NULL,
	`max_col_yz` int(11) NOT NULL,
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
	`w12` int(11) NOT NULL,
	`lt1` int(11) NOT NULL,
	`lt2` int(11) NOT NULL,
	`lt3` int(11) NOT NULL,
	`lt4` int(11) NOT NULL,
	`lt5` int(11) NOT NULL,
	`lt6` int(11) NOT NULL,
	`lt7` int(11) NOT NULL,
	`lt8` int(11) NOT NULL,
	`lt9` int(11) NOT NULL,
	`lt10` int(11) NOT NULL,
	`lt11` int(11) NOT NULL,
	`lt12` int(11) NOT NULL,
	`t1` int(11) NOT NULL,
	`t2` int(11) NOT NULL,
	`t3` int(11) NOT NULL,
	`t4` int(11) NOT NULL,
	`t5` int(11) NOT NULL,
	`t6` int(11) NOT NULL,
	`t7` int(11) NOT NULL,
	`t8` int(11) NOT NULL,
	`t9` int(11) NOT NULL,
	`t10` int(11) NOT NULL,
	`t11` int(11) NOT NULL,
	`t12` int(11) NOT NULL,
	`w1pos` int(11) NOT NULL,
	`w2pos` int(11) NOT NULL,
	`w3pos` int(11) NOT NULL,
	`w4pos` int(11) NOT NULL,
	`w5pos` int(11) NOT NULL,
	`w6pos` int(11) NOT NULL,
	`w7pos` int(11) NOT NULL,
	`w8pos` int(11) NOT NULL,
	`w9pos` int(11) NOT NULL,
	`w10pos` int(11) NOT NULL,
	`w11pos` int(11) NOT NULL,
	`w12pos` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);