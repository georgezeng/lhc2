package net.geozen.lhc2.service.qq;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.QqNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class QqCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return QqNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return QqNums.LISTS;
	}

}
