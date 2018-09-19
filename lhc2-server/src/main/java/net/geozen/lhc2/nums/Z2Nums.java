package net.geozen.lhc2.nums;

import java.util.ArrayList;
import java.util.List;

public class Z2Nums {
	public static final List<List<Integer>> LISTS = new ArrayList<>();
	static {
		int backNum = 47;
		int backNum2 = 23;
		int forwardNum = 27;
		for (int i = 1; i < 13; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			if (i < 12) {
				list.add(backNum--);
				if (i < 11) {
					list.add(forwardNum++);
					list.add(backNum2--);
				} else {
					list.add(26);
					list.add(48);
				}
			} else {
				list.add(13);
				list.add(24);
				list.add(25);
				list.add(49);
			}
			LISTS.add(list);
		}
	}
}
