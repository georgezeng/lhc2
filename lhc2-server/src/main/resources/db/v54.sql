--liquibase formatted sql

--changeset lhc2:54

ALTER TABLE `lhc3_color_yz_2`
ADD COLUMN `wr_cost` decimal(20, 2) NOT NULL,
ADD COLUMN `wr_income` decimal(20, 2) NOT NULL,
ADD COLUMN `wr_costt` decimal(20, 2) NOT NULL,
ADD COLUMN `wr_incomet` decimal(20, 2) NOT NULL,
ADD COLUMN `wr_costlt` decimal(20, 2) NOT NULL,
ADD COLUMN `wr_incomelt` decimal(20, 2) NOT NULL,
ADD COLUMN `yzr_cost` decimal(20, 2) NOT NULL,
ADD COLUMN `yzr_income` decimal(20, 2) NOT NULL,
ADD COLUMN `yzr_costt` decimal(20, 2) NOT NULL,
ADD COLUMN `yzr_incomet` decimal(20, 2) NOT NULL,
ADD COLUMN `yzr_costlt` decimal(20, 2) NOT NULL,
ADD COLUMN `yzr_incomelt` decimal(20, 2) NOT NULL,
ADD COLUMN `yzg_cost` decimal(20, 2) NOT NULL,
ADD COLUMN `yzg_income` decimal(20, 2) NOT NULL,
ADD COLUMN `yzg_costt` decimal(20, 2) NOT NULL,
ADD COLUMN `yzg_incomet` decimal(20, 2) NOT NULL,
ADD COLUMN `yzg_costlt` decimal(20, 2) NOT NULL,
ADD COLUMN `yzg_incomelt` decimal(20, 2) NOT NULL;