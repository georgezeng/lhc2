package net.geozen.lhc2.service.slq.bs;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.SlqbsNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SlqbsCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return SlqbsNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return SlqbsNums.LISTS;
	}

}
