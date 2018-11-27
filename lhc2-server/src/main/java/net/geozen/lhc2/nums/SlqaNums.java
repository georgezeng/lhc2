package net.geozen.lhc2.nums;

import java.util.ArrayList;
import java.util.List;

public class SlqaNums {
	public static final List<List<Integer>> LISTS = new ArrayList<>();
	static {
		List<Integer> list = null;
		for (int i = 1; i < 50; i++) {
			if (i < 49) {
				if (i % 3 == 1) {
					list = new ArrayList<>();
				}
			}
			list.add(i);
			if (i % 3 == 0) {
				LISTS.add(list);
			}
		}
	}
}
