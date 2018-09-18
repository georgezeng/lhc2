package net.geozen.lhc2.service.qq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class QqCalculationHandler implements CalculationHandler {
	private List<List<Integer>> lists = new ArrayList<>();
	{
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			list.add(i);
			if (i % 7 == 0) {
				lists.add(list);
				if (i < 49) {
					list = new ArrayList<>();
				}
			}
		}
	}

	@Override
	public int getLength() {
		return 7;
	}

	@Override
	public List<List<Integer>> getLists() {
		return lists;
	}

}
