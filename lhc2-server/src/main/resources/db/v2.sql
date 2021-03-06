--liquibase formatted sql

--changeset lhc2:2

CREATE TABLE `sxyz` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`sx` varchar(5) NOT NULL,
	`shu` int(11) NOT NULL,
	`niu` int(11) NOT NULL,
	`hu` int(11) NOT NULL,
	`tu` int(11) NOT NULL,
	`lonng` int(11) NOT NULL,
	`she` int(11) NOT NULL,
	`ma` int(11) NOT NULL,
	`yang` int(11) NOT NULL,
	`hou` int(11) NOT NULL,
	`ji` int(11) NOT NULL,
	`gou` int(11) NOT NULL,
	`zhu` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `sxzf` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`sx` varchar(5) NOT NULL,
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

CREATE TABLE `sxsw` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`phase` int(11) NOT NULL,
	`num` int(11) NOT NULL,
	`sx` varchar(5) NOT NULL,
	`sw1sx` varchar(5) NOT NULL,
	`sw2sx` varchar(5) NOT NULL,
	`sw3sx` varchar(5) NOT NULL,
	`sw4sx` varchar(5) NOT NULL,
	`sw5sx` varchar(5) NOT NULL,
	`sw6sx` varchar(5) NOT NULL,
	`sw7sx` varchar(5) NOT NULL,
	`sw8sx` varchar(5) NOT NULL,
	`sw9sx` varchar(5) NOT NULL,
	`sw10sx` varchar(5) NOT NULL,
	`sw11sx` varchar(5) NOT NULL,
	`sw12sx` varchar(5) NOT NULL,
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
	PRIMARY KEY (`id`)
);