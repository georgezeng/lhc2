package net.geozen.lhc2.service.mw;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class MwCalculationHandler implements CalculationHandler {
	@Override
	public int getPos(int num) {
		DecimalFormat df = new DecimalFormat("00");
		String str = df.format(num);
		return Integer.valueOf(str.substring(1, 2));
	}

	@Override
	public int getLength() {
		return 10;
	}

	@Override
	public List<List<Integer>> getLists() {
		return null;
	}

}
