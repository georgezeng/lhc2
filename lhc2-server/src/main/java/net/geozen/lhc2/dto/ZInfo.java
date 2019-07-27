package net.geozen.lhc2.dto;

import java.math.BigDecimal;
import java.util.List;

public class ZInfo {
	private int order;
	private BigDecimal z;
	private BigDecimal zForP1;
	private List<Integer> nums;
	private List<Integer> numsForD1;
	private List<Integer> numsForD2;
	private List<Integer> numsForD3;
	private List<Integer> numsForS2;
	private List<Integer> minNums;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public BigDecimal getZ() {
		return z;
	}

	public void setZ(BigDecimal z) {
		this.z = z;
	}

	public BigDecimal getZForP1() {
		return zForP1;
	}

	public void setZForP1(BigDecimal zForP1) {
		this.zForP1 = zForP1;
	}

	public List<Integer> getNums() {
		return nums;
	}

	public void setNums(List<Integer> nums) {
		this.nums = nums;
	}

	public List<Integer> getNumsForD1() {
		return numsForD1;
	}

	public void setNumsForD1(List<Integer> numsForD1) {
		this.numsForD1 = numsForD1;
	}

	public List<Integer> getNumsForD2() {
		return numsForD2;
	}

	public void setNumsForD2(List<Integer> numsForD2) {
		this.numsForD2 = numsForD2;
	}

	public List<Integer> getNumsForD3() {
		return numsForD3;
	}

	public void setNumsForD3(List<Integer> numsForD3) {
		this.numsForD3 = numsForD3;
	}

	public List<Integer> getNumsForS2() {
		return numsForS2;
	}

	public void setNumsForS2(List<Integer> numsForS2) {
		this.numsForS2 = numsForS2;
	}

	public List<Integer> getMinNums() {
		return minNums;
	}

	public void setMinNums(List<Integer> minNums) {
		this.minNums = minNums;
	}
}
