package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lhc3_pick_num")
public class Lhc3PickNum {
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public int getExpected() {
		return expected;
	}
	public void setExpected(int expected) {
		this.expected = expected;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime0() {
		return time0;
	}
	public void setTime0(String time0) {
		this.time0 = time0;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getTime2Plus() {
		return time2Plus;
	}
	public void setTime2Plus(String time2Plus) {
		this.time2Plus = time2Plus;
	}
	public String getTime3Plus() {
		return time3Plus;
	}
	public void setTime3Plus(String time3Plus) {
		this.time3Plus = time3Plus;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phase;
	private int num;
	private String payload;
	private int expected;
	private String type;
	private String time0;
	private String time1;
	private String time2;
	private String time2Plus;
	private String time3Plus;
}
