package net.geozen.lhc2.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StatTotallyInfo {
	private List<Integer> nums = new ArrayList<>();
	private int count;

	public void add(Integer num) {
		nums.add(num);
	}
}
