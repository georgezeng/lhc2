package net.geozen.lhc2.service.z2;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.Z2Nums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class Z2CalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return Z2Nums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return Z2Nums.LISTS;
	}

}
