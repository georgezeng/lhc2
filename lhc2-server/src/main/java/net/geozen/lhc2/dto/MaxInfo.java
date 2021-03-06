package net.geozen.lhc2.dto;

import java.util.ArrayList;
import java.util.List;

import net.geozen.lhc2.enums.SX;

public class MaxInfo {
	private int phase;
	private int yz;
	private int pos;
	private SX sx;
	private List<Integer> nums;

	public MaxInfo(int phase, int yz, int pos) {
		this.phase = phase;
		this.yz = yz;
		this.pos = pos;
	}

	public MaxInfo(int phase, int yz, SX sx) {
		this.phase = phase;
		this.yz = yz;
		this.sx = sx;
	}

	public MaxInfo(int phase, int yz, String[] arr) {
		this.phase = phase;
		this.yz = yz;
		this.nums = new ArrayList<Integer>();
		if (arr != null) {
			for (String num : arr) {
				nums.add(Integer.valueOf(num));
			}
		}
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public int getYz() {
		return yz;
	}

	public void setYz(int yz) {
		this.yz = yz;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public SX getSx() {
		return sx;
	}

	public void setSx(SX sx) {
		this.sx = sx;
	}

	public List<Integer> getNums() {
		return nums;
	}

	public void setNums(List<Integer> nums) {
		this.nums = nums;
	}
}