package net.geozen.lhc2.nums;

import java.util.ArrayList;
import java.util.List;

public class QqNums {
	public static final List<List<Integer>> LISTS = new ArrayList<>();
	static {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			list.add(i);
			if (i % 7 == 0) {
				LISTS.add(list);
				if (i < 49) {
					list = new ArrayList<>();
				}
			}
		}
	}
}
