package net.geozen.lhc3.domain.base;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class PosBaseEntity extends BaseEntity {
	private int pos;
	private int totalColsYz; // 所有列的遗值和
	private int rColsYz; // 倒1-倒5 遗值和
	private int maxColYz; // 同一行最大遗值和
	
	private int w1;
	private int w2;
	private int w3;
	private int w4;
	private int w5;
	private int w6;
	private int w7;
	private int w8;
	private int w9;
	private int w10;
	private int w11;
	private int w12;

	private int lt1;
	private int lt2;
	private int lt3;
	private int lt4;
	private int lt5;
	private int lt6;
	private int lt7;
	private int lt8;
	private int lt9;
	private int lt10;
	private int lt11;
	private int lt12;
	
	private int t1;
	private int t2;
	private int t3;
	private int t4;
	private int t5;
	private int t6;
	private int t7;
	private int t8;
	private int t9;
	private int t10;
	private int t11;
	private int t12;
}
