package net.geozen.lhc2.service.slq.d;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.SlqdNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SlqdCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return SlqdNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return SlqdNums.LISTS;
	}

}
