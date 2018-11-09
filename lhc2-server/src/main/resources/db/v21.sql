--liquibase formatted sql

--changeset lhc2:21

ALTER TABLE `times_yz` 
ADD COLUMN `num` int(11) NOT NULL;