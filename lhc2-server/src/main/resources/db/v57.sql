--liquibase formatted sql

--changeset lhc2:57

ALTER TABLE `analyze_yz`
ADD COLUMN `last_yz0` int(11),
ADD COLUMN `last_yz1p` int(11),
ADD COLUMN `last_yz0light` int(11),
ADD COLUMN `last_yz1p_light` int(11),
ADD COLUMN `last_nums0` int(11),
ADD COLUMN `last_nums0avg` int(11),
ADD COLUMN `last_nums1p` int(11),
ADD COLUMN `last_nums1p_avg` int(11);
