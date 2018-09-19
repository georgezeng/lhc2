package net.geozen.lhc2.service.pd;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.PdNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class PdCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return PdNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return PdNums.LISTS;
	}

}
