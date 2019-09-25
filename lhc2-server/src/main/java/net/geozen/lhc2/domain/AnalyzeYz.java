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
