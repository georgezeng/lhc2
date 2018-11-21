package net.geozen.lhc2.service.dxds;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.Dxds2Nums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class Dxds2CalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return Dxds2Nums.LISTS.size();
	}
	
	@Override
	public boolean isFiltered(int num) {
		return num == 49;
	}

	@Override
	public String getIndexStr(int index) {
		switch (index) {
		case 0:
			return "SmallOdd";
		case 1:
			return "SmallEven";
		case 2:
			return "LargeOdd";
		case 3:
			return "LargeEven";
		default:
			throw new RuntimeException("index[" + index + "]有误");
		}
	}

	@Override
	public List<List<Integer>> getLists() {
		return Dxds2Nums.LISTS;
	}
}
