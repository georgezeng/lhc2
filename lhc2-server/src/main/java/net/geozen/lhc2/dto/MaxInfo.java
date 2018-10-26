package net.geozen.lhc2.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import net.geozen.lhc2.enums.SX;

@Data
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
}