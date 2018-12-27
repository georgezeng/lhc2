--liquibase formatted sql

--changeset lhc2:28

ALTER TABLE `pick_num` 
ADD COLUMN `type` varchar(50);


