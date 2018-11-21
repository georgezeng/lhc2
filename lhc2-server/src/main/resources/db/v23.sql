--liquibase formatted sql

--changeset lhc2:23

ALTER TABLE `times_yz` 
ADD COLUMN `pos` int(11) NOT NULL,
ADD COLUMN `zf0` int(11) NOT NULL,
ADD COLUMN `zf1` int(11) NOT NULL,
ADD COLUMN `zf2` int(11) NOT NULL;


ALTER TABLE `color_yz` 
ADD COLUMN `wr_color` varchar(20) NOT NULL,
ADD COLUMN `wr` int(11) NOT NULL;