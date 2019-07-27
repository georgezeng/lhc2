package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

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
	public int getTime12() {
		return time12;
	}
	public void setTime12(int time12) {
		this.time12 = time12;
	}
	public int getTime2Plus() {
		return time2Plus;
	}
	public void setTime2Plus(int time2Plus) {
		this.time2Plus = time2Plus;
	}
	public int getTime03Plus() {
		return time03Plus;
	}
	public void setTime03Plus(int time03Plus) {
		this.time03Plus = time03Plus;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getLt12() {
		return lt12;
	}
	public void setLt12(int lt12) {
		this.lt12 = lt12;
	}
	public int getLt2Plus() {
		return lt2Plus;
	}
	public void setLt2Plus(int lt2Plus) {
		this.lt2Plus = lt2Plus;
	}
	public int getLt03Plus() {
		return lt03Plus;
	}
	public void setLt03Plus(int lt03Plus) {
		this.lt03Plus = lt03Plus;
	}
	public int getT12() {
		return t12;
	}
	public void setT12(int t12) {
		this.t12 = t12;
	}
	public int getT2Plus() {
		return t2Plus;
	}
	public void setT2Plus(int t2Plus) {
		this.t2Plus = t2Plus;
	}
	public int getT03Plus() {
		return t03Plus;
	}
	public void setT03Plus(int t03Plus) {
		this.t03Plus = t03Plus;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phase;
	private String tables;
	private String type;
	private int time12;
	private int time2Plus;
	private int time03Plus;
	private int num;
	private int lt12;
	private int lt2Plus;
	private int lt03Plus;
	private int t12;
	private int t2Plus;
	private int t03Plus;
}
