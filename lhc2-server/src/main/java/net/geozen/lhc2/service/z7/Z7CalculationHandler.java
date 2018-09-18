package net.geozen.lhc2.service.z7;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class Z7CalculationHandler implements CalculationHandler {
	private List<List<Integer>> lists = new ArrayList<>();
	{
		int backNum = 19;
		int backNum2 = 39;
		int forwardNum = 21;
		int lastNum = 40;
		for (int i = 1; i < 11; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			if (i < 10) {
				list.add(backNum--);
			}
			list.add(forwardNum++);
			list.add(backNum2--);
			if (i < 5) {
				list.add(lastNum++);
			} else if (i > 5 && i < 9) {
				if (i == 6) {
					lastNum = 46;
				}
				list.add(lastNum++);
			} else if (i == 9) {
				list.add(45);
			} else if (i == 10) {
				list.add(44);
				list.add(49);
			}
			lists.add(list);
		}
	}

	@Override
	public int getLength() {
		return 10;
	}

	@Override
	public List<List<Integer>> getLists() {
		return lists;
	}

}
