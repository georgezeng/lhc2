--liquibase formatted sql

--changeset lhc2:18

ALTER TABLE `tm` 
ADD UNIQUE INDEX `idx_tm_phase`(`phase`);
