package net.geozen.lhc2.nums;

import java.util.ArrayList;
import java.util.List;

public class Dxds1bNums {
	public static final List<List<Integer>> LISTS = new ArrayList<>();
	static {
		List<Integer> odd = new ArrayList<>();
		for (int i = 1; i < 49; i++) {
			if (i % 2 != 0) {
				odd.add(i);
			}
		}
		LISTS.add(odd);

		List<Integer> even = new ArrayList<>();
		for (int i = 1; i < 49; i++) {
			if (i % 2 == 0) {
				even.add(i);
			}
		}
		LISTS.add(even);
	}
}
