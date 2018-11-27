package net.geozen.lhc2.service.slq.b;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.SlqbNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SlqbCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return SlqbNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return SlqbNums.LISTS;
	}

}
