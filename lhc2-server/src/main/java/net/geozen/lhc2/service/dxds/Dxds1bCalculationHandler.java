package net.geozen.lhc2.service.dxds;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.Dxds1bNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class Dxds1bCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return Dxds1bNums.LISTS.size();
	}
	
	@Override
	public boolean isFiltered(int num) {
		return num == 49;
	}
	
	@Override
	public boolean isDelete() {
		return false;
	}

	@Override
	public String getIndexStr(int index) {
		switch (index) {
		case 0:
			return "Odd";
		case 1:
			return "Even";
		default:
			throw new RuntimeException("index[" + index + "]有误");
		}
	}

	@Override
	public List<List<Integer>> getLists() {
		return Dxds1bNums.LISTS;
	}
}
