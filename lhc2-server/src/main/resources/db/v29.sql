--liquibase formatted sql

--changeset lhc2:29

ALTER TABLE `color_yz` 
ADD COLUMN `type` varchar(50);

ALTER TABLE `times_yz` 
ADD COLUMN `type` varchar(50);

