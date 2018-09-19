package net.geozen.lhc2.service.bs;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.BsNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class BsCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return BsNums.LISTS.size();
	}

	@Override
	public String getIndexStr(int index) {
		if (index < 3) {
			return "Red" + (index + 1);
		} else if (index < 6) {
			return "Blue" + (index % 3 + 1);
		} else {
			return "Green" + (index % 3 + 1);
		}
	}

	@Override
	public List<List<Integer>> getLists() {
		return BsNums.LISTS;
	}
}
