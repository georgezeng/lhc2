--liquibase formatted sql

--changeset lhc2:24

ALTER TABLE `dxds2yz` 
ADD COLUMN `rg_color` varchar(20),
ADD COLUMN `rg` int(11);

ALTER TABLE `dxds2zf` 
ADD COLUMN `rg_color` varchar(20),
ADD COLUMN `rg` int(11);