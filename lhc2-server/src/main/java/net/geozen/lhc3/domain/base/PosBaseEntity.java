package net.geozen.lhc3.domain.base;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PosBaseEntity extends BaseEntity {
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getTotalColsYz() {
		return totalColsYz;
	}
	public void setTotalColsYz(int totalColsYz) {
		this.totalColsYz = totalColsYz;
	}
	public int getrColsYz() {
		return rColsYz;
	}
	public void setrColsYz(int rColsYz) {
		this.rColsYz = rColsYz;
	}
	public int getMaxColYz() {
		return maxColYz;
	}
	public void setMaxColYz(int maxColYz) {
		this.maxColYz = maxColYz;
	}
	public int getW1() {
		return w1;
	}
	public void setW1(int w1) {
		this.w1 = w1;
	}
	public int getW2() {
		return w2;
	}
	public void setW2(int w2) {
		this.w2 = w2;
	}
	public int getW3() {
		return w3;
	}
	public void setW3(int w3) {
		this.w3 = w3;
	}
	public int getW4() {
		return w4;
	}
	public void setW4(int w4) {
		this.w4 = w4;
	}
	public int getW5() {
		return w5;
	}
	public void setW5(int w5) {
		this.w5 = w5;
	}
	public int getW6() {
		return w6;
	}
	public void setW6(int w6) {
		this.w6 = w6;
	}
	public int getW7() {
		return w7;
	}
	public void setW7(int w7) {
		this.w7 = w7;
	}
	public int getW8() {
		return w8;
	}
	public void setW8(int w8) {
		this.w8 = w8;
	}
	public int getW9() {
		return w9;
	}
	public void setW9(int w9) {
		this.w9 = w9;
	}
	public int getW10() {
		return w10;
	}
	public void setW10(int w10) {
		this.w10 = w10;
	}
	public int getW11() {
		return w11;
	}
	public void setW11(int w11) {
		this.w11 = w11;
	}
	public int getW12() {
		return w12;
	}
	public void setW12(int w12) {
		this.w12 = w12;
	}
	public int getLt1() {
		return lt1;
	}
	public void setLt1(int lt1) {
		this.lt1 = lt1;
	}
	public int getLt2() {
		return lt2;
	}
	public void setLt2(int lt2) {
		this.lt2 = lt2;
	}
	public int getLt3() {
		return lt3;
	}
	public void setLt3(int lt3) {
		this.lt3 = lt3;
	}
	public int getLt4() {
		return lt4;
	}
	public void setLt4(int lt4) {
		this.lt4 = lt4;
	}
	public int getLt5() {
		return lt5;
	}
	public void setLt5(int lt5) {
		this.lt5 = lt5;
	}
	public int getLt6() {
		return lt6;
	}
	public void setLt6(int lt6) {
		this.lt6 = lt6;
	}
	public int getLt7() {
		return lt7;
	}
	public void setLt7(int lt7) {
		this.lt7 = lt7;
	}
	public int getLt8() {
		return lt8;
	}
	public void setLt8(int lt8) {
		this.lt8 = lt8;
	}
	public int getLt9() {
		return lt9;
	}
	public void setLt9(int lt9) {
		this.lt9 = lt9;
	}
	public int getLt10() {
		return lt10;
	}
	public void setLt10(int lt10) {
		this.lt10 = lt10;
	}
	public int getLt11() {
		return lt11;
	}
	public void setLt11(int lt11) {
		this.lt11 = lt11;
	}
	public int getLt12() {
		return lt12;
	}
	public void setLt12(int lt12) {
		this.lt12 = lt12;
	}
	public int getT1() {
		return t1;
	}
	public void setT1(int t1) {
		this.t1 = t1;
	}
	public int getT2() {
		return t2;
	}
	public void setT2(int t2) {
		this.t2 = t2;
	}
	public int getT3() {
		return t3;
	}
	public void setT3(int t3) {
		this.t3 = t3;
	}
	public int getT4() {
		return t4;
	}
	public void setT4(int t4) {
		this.t4 = t4;
	}
	public int getT5() {
		return t5;
	}
	public void setT5(int t5) {
		this.t5 = t5;
	}
	public int getT6() {
		return t6;
	}
	public void setT6(int t6) {
		this.t6 = t6;
	}
	public int getT7() {
		return t7;
	}
	public void setT7(int t7) {
		this.t7 = t7;
	}
	public int getT8() {
		return t8;
	}
	public void setT8(int t8) {
		this.t8 = t8;
	}
	public int getT9() {
		return t9;
	}
	public void setT9(int t9) {
		this.t9 = t9;
	}
	public int getT10() {
		return t10;
	}
	public void setT10(int t10) {
		this.t10 = t10;
	}
	public int getT11() {
		return t11;
	}
	public void setT11(int t11) {
		this.t11 = t11;
	}
	public int getT12() {
		return t12;
	}
	public void setT12(int t12) {
		this.t12 = t12;
	}
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
