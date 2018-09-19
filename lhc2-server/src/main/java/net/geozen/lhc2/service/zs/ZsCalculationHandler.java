package net.geozen.lhc2.service.zs;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.ZsNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class ZsCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return ZsNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return ZsNums.LISTS;
	}

}
