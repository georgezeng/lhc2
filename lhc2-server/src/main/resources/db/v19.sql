--liquibase formatted sql

--changeset lhc2:19

ALTER TABLE `pick_num` 
ADD COLUMN `tm` int(11) NOT NULL;
