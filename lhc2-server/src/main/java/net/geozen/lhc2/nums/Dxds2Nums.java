package net.geozen.lhc2.nums;

import java.util.ArrayList;
import java.util.List;

public class Dxds2Nums {
	public static final List<List<Integer>> LISTS = new ArrayList<>();
	static {
		List<Integer> smallOdd = new ArrayList<>();
		for (int i = 1; i < 25; i++) {
			if (i % 2 != 0) {
				smallOdd.add(i);
			}
		}
		LISTS.add(smallOdd);

		List<Integer> smallEven = new ArrayList<>();
		for (int i = 1; i < 25; i++) {
			if (i % 2 == 0) {
				smallEven.add(i);
			}
		}
		LISTS.add(smallEven);

		List<Integer> largeOdd = new ArrayList<>();
		for (int i = 25; i < 49; i++) {
			if (i % 2 != 0) {
				largeOdd.add(i);
			}
		}
		LISTS.add(largeOdd);

		List<Integer> largeEven = new ArrayList<>();
		for (int i = 25; i < 49; i++) {
			if (i % 2 == 0) {
				largeEven.add(i);
			}
		}
		LISTS.add(largeEven);
	}
}
