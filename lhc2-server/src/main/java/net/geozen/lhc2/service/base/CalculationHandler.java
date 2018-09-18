package net.geozen.lhc2.service.base;

import java.util.List;

public interface CalculationHandler {
	List<List<Integer>> getLists();

	default int getPos(int num) {
		int index = 0;
		for (List<Integer> list : getLists()) {
			if (list.contains(num)) {
				return index;
			}
			index++;
		}
		throw new RuntimeException("号码[" + num + "]有误");
	}

	int getLength();

	default String getIndexStr(int index) {
		return "W" + index;
	}
}
