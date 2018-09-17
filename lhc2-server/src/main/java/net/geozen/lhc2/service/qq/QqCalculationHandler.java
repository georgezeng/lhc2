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
	public int getPos(int num) {
		int index = 0;
		for (List<Integer> list : lists) {
			if (list.contains(num)) {
				return index;
			}
			index++;
		}
		throw new RuntimeException("号码[" + num + "]有误");
	}

	@Override
	public int getLength() {
		return 7;
	}

}
