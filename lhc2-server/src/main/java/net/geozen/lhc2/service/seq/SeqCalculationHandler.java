package net.geozen.lhc2.service.seq;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.nums.SeqNums;
import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SeqCalculationHandler implements CalculationHandler {

	@Override
	public int getLength() {
		return SeqNums.LISTS.size();
	}

	@Override
	public List<List<Integer>> getLists() {
		return SeqNums.LISTS;
	}

}
