package net.geozen.lhc2.service.slq;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.SlqNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SlqCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return SlqNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return SlqNums.LISTS;
	}

}
