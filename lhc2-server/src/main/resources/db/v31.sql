--liquibase formatted sql

--changeset lhc2:31

ALTER TABLE `color_yz` 
ADD COLUMN `lz` int(11) NOT NULL,
ADD COLUMN `ch` int(11) NOT NULL,
ADD COLUMN `ch_color` varchar(50) NOT NULL,
ADD COLUMN `lz_color` varchar(50) NOT NULL;