package net.geozen.lhc2.service.slq.wx;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.SlqwxNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SlqwxCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return SlqwxNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return SlqwxNums.LISTS;
	}

}
