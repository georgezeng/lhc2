package net.geozen.lhc2.service.slq.zs;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.SlqzsNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SlqzsCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return SlqzsNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return SlqzsNums.LISTS;
	}

}
