package net.geozen.lhc2.service.z13;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.Z13Nums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class Z13CalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return Z13Nums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return Z13Nums.LISTS;
	}

}
