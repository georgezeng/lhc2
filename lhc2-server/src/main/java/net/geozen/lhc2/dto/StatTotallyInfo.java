package net.geozen.lhc2.dto;

import java.util.ArrayList;
import java.util.List;

public class StatTotallyInfo {
	private List<Integer> nums = new ArrayList<>();
	private int count;

	public List<Integer> getNums() {
		return nums;
	}

	public void setNums(List<Integer> nums) {
		this.nums = nums;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void add(Integer num) {
		nums.add(num);
	}
}
