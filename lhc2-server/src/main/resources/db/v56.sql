--liquibase formatted sql

--changeset lhc2:56

ALTER TABLE `analyze_yz`
ADD COLUMN `nums0arr` varchar(255),
ADD COLUMN `nums1parr` varchar(255);
