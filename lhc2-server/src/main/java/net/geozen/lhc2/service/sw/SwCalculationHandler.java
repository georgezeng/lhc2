package net.geozen.lhc2.service.sw;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class SwCalculationHandler implements CalculationHandler {
	@Override
	public int getPos(int num) {
		int pos = 4;
		if (num < 10) {
			pos = 0;
		} else if (num < 20) {
			pos = 1;
		} else if (num < 30) {
			pos = 2;
		} else if (num < 40) {
			pos = 3;
		}
		return pos;
	}

	@Override
	public int getLength() {
		return 5;
	}

	@Override
	public List<List<Integer>> getLists() {
		return null;
	}

}
