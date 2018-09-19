package net.geozen.lhc2.service.z7;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.Z7Nums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class Z7CalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return Z7Nums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return Z7Nums.LISTS;
	}

}
