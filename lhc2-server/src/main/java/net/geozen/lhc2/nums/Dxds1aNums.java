package net.geozen.lhc2.nums;

import java.util.ArrayList;
import java.util.List;

public class Dxds1aNums {
	public static final List<List<Integer>> LISTS = new ArrayList<>();
	static {
		List<Integer> small = new ArrayList<>();
		for (int i = 1; i < 25; i++) {
			small.add(i);
		}
		LISTS.add(small);

		List<Integer> large = new ArrayList<>();
		for (int i = 25; i < 49; i++) {
			large.add(i);
		}
		LISTS.add(large);
	}
}
