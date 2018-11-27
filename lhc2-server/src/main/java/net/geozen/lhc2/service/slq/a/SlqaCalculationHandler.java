package net.geozen.lhc2.service.slq.a;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.SlqaNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SlqaCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return SlqaNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return SlqaNums.LISTS;
	}

}
