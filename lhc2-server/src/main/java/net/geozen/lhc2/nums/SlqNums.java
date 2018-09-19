package net.geozen.lhc2.nums;

import java.util.ArrayList;
import java.util.List;

public class SlqNums {
	public static final List<List<Integer>> LISTS = new ArrayList<>();
	static {
		int backNum = 49;
		int reverse = -1;
		int indexNum = 25;
		for (int i = 1; i < 17; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			reverse *= -1;
			indexNum = indexNum + i * reverse;
			list.add(indexNum);
			if (i == 16) {
				list.add(25);
			}
			list.add(backNum--);
			LISTS.add(list);
		}
	}
}
