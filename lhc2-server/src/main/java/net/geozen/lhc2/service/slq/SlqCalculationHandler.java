package net.geozen.lhc2.service.slq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SlqCalculationHandler implements CalculationHandler {
	private List<List<Integer>> lists = new ArrayList<>();
	{
		int backNum = 49;
		int reverse = -1;
		int indexNum = 25;
		for (int i = 1; i < 17; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			reverse *= -1;
			indexNum = indexNum + i * reverse;
			list.add(indexNum);
			list.add(backNum--);
			lists.add(list);
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
		return 16;
	}

}
