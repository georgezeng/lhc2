package net.geozen.lhc2.service.ds;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.DsNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class DsCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return DsNums.LISTS.size();
	}

	@Override
	public String getIndexStr(int index) {
		switch (index) {
		case 0:
			return "Odd0";
		case 1:
			return "Even0";
		case 2:
			return "Odd1";
		case 3:
			return "Even1";
		case 4:
			return "Odd2";
		case 5:
			return "Even2";
		case 6:
			return "Odd3";
		case 7:
			return "Even3";
		case 8:
			return "Odd4";
		case 9:
			return "Even4";
		default:
			throw new RuntimeException("index[" + index + "]有误");
		}
	}

	@Override
	public List<List<Integer>> getLists() {
		return DsNums.LISTS;
	}
}
