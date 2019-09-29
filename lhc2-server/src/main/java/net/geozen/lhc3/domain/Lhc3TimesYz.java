package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lhc3_times_yz")
public class Lhc3TimesYz {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getTables() {
		return tables;
	}
	public void setTables(String tables) {
		this.tables = tables;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTime0() {
		return time0;
	}
	public void setTime0(int time0) {
		this.time0 = time0;
	}
	public int getTime1() {
		return time1;
	}
	public void setTime1(int time1) {
		this.time1 = time1;
	}
	public int getTime2() {
		return time2;
	}
	public void setTime2(int time2) {
		this.time2 = time2;
	}
	public int getTime3Plus() {
		return time3Plus;
	}
	public void setTime3Plus(int time3Plus) {
		this.time3Plus = time3Plus;
	}
	public int getLt0() {
		return lt0;
	}
	public void setLt0(int lt0) {
		this.lt0 = lt0;
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
	public int getLt3Plus() {
		return lt3Plus;
	}
	public void setLt3Plus(int lt3Plus) {
		this.lt3Plus = lt3Plus;
	}
	public int getT0() {
		return t0;
	}
	public void setT0(int t0) {
		this.t0 = t0;
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
	public int getT3Plus() {
		return t3Plus;
	}
	public void setT3Plus(int t3Plus) {
		this.t3Plus = t3Plus;
	}
	public int getTime1Plus() {
		return time1Plus;
	}
	public void setTime1Plus(int time1Plus) {
		this.time1Plus = time1Plus;
	}
	public int getLt1Plus() {
		return lt1Plus;
	}
	public void setLt1Plus(int lt1Plus) {
		this.lt1Plus = lt1Plus;
	}
	public int getT1Plus() {
		return t1Plus;
	}
	public void setT1Plus(int t1Plus) {
		this.t1Plus = t1Plus;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phase;
	private String tables;
	private String type;
	private int num;
	private int time0;
	private int time1;
	private int time2;
	private int time3Plus;
	private int time1Plus;
	private int lt0;
	private int lt1;
	private int lt2;
	private int lt3Plus;
	private int lt1Plus;
	private int t0;
	private int t1;
	private int t2;
	private int t3Plus;
	private int t1Plus;
}
