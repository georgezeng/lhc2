package net.geozen.lhc2.service.seq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SeqCalculationHandler implements CalculationHandler {
	private List<List<Integer>> lists = new ArrayList<>();
	{
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			list.add(i);
			if (i % 4 == 0) {
				lists.add(list);
				if (i < 48) {
					list = new ArrayList<>();
				}
			}
		}
	}

	@Override
	public int getLength() {
		return 12;
	}

	@Override
	public List<List<Integer>> getLists() {
		return lists;
	}

}
