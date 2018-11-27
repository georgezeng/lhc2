package net.geozen.lhc2.service.slq.c;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.SlqcNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SlqcCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return SlqcNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return SlqcNums.LISTS;
	}

}
