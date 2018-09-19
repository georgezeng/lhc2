package net.geozen.lhc2.nums;

import java.util.ArrayList;
import java.util.List;

public class SeqNums {

	public static final List<List<Integer>> LISTS = new ArrayList<>();
	static {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			list.add(i);
			if (i % 4 == 0) {
				LISTS.add(list);
				if (i < 48) {
					list = new ArrayList<>();
				}
			}
		}
	}
}
