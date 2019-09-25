package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "analyze_yz")
public class AnalyzeYz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int phase;
	private int tm;
	private int expected;
	private String type;
	private int yz0;
	private int yz1p;
	private int yz0light;
	private int yz1pLight;
	private int nums0;
	private int nums0Avg;
	private int nums1p;
	private int nums1pAvg;
	private String nums0arr;
	private String nums1parr;
	private int lastYz0;
	private int lastYz1p;
	private int lastYz0light;
	private int lastYz1pLight;
	private int lastNums0;
	private int lastNums0Avg;
	private int lastNums1p;
	private int lastNums1pAvg;

	public int getLastYz0() {
		return lastYz0;
	}

	public void setLastYz0(int lastYz0) {
		this.lastYz0 = lastYz0;
	}

	public int getLastYz1p() {
		return lastYz1p;
	}

	public void setLastYz1p(int lastYz1p) {
		this.lastYz1p = lastYz1p;
	}

	public int getLastYz0light() {
		return lastYz0light;
	}

	public void setLastYz0light(int lastYz0light) {
		this.lastYz0light = lastYz0light;
	}

	public int getLastYz1pLight() {
		return lastYz1pLight;
	}

	public void setLastYz1pLight(int lastYz1pLight) {
		this.lastYz1pLight = lastYz1pLight;
	}

	public int getLastNums0() {
		return lastNums0;
	}

	public void setLastNums0(int lastNums0) {
		this.lastNums0 = lastNums0;
	}

	public int getLastNums0Avg() {
		return lastNums0Avg;
	}

	public void setLastNums0Avg(int lastNums0Avg) {
		this.lastNums0Avg = lastNums0Avg;
	}

	public int getLastNums1p() {
		return lastNums1p;
	}

	public void setLastNums1p(int lastNums1p) {
		this.lastNums1p = lastNums1p;
	}

	public int getLastNums1pAvg() {
		return lastNums1pAvg;
	}

	public void setLastNums1pAvg(int lastNums1pAvg) {
		this.lastNums1pAvg = lastNums1pAvg;
	}

	public String getNums0arr() {
		return nums0arr;
	}

	public void setNums0arr(String nums0arr) {
		this.nums0arr = nums0arr;
	}

	public String getNums1parr() {
		return nums1parr;
	}

	public void setNums1parr(String nums1parr) {
		this.nums1parr = nums1parr;
	}

	public int getExpected() {
		return expected;
	}

	public void setExpected(int expected) {
		this.expected = expected;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public int getTm() {
		return tm;
	}

	public void setTm(int tm) {
		this.tm = tm;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYz0() {
		return yz0;
	}

	public void setYz0(int yz0) {
		this.yz0 = yz0;
	}

	public int getYz1p() {
		return yz1p;
	}

	public void setYz1p(int yz1p) {
		this.yz1p = yz1p;
	}

	public int getYz0light() {
		return yz0light;
	}

	public void setYz0light(int yz0light) {
		this.yz0light = yz0light;
	}

	public int getYz1pLight() {
		return yz1pLight;
	}

	public void setYz1pLight(int yz1pLight) {
		this.yz1pLight = yz1pLight;
	}

	public int getNums0() {
		return nums0;
	}

	public void setNums0(int nums0) {
		this.nums0 = nums0;
	}

	public int getNums0Avg() {
		return nums0Avg;
	}

	public void setNums0Avg(int nums0Avg) {
		this.nums0Avg = nums0Avg;
	}

	public int getNums1p() {
		return nums1p;
	}

	public void setNums1p(int nums1p) {
		this.nums1p = nums1p;
	}

	public int getNums1pAvg() {
		return nums1pAvg;
	}

	public void setNums1pAvg(int nums1pAvg) {
		this.nums1pAvg = nums1pAvg;
	}
}
