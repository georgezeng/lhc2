package net.geozen.lhc2.service.hs;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class HsCalculationHandler implements CalculationHandler {
	@Override
	public int getPos(int num) {
		DecimalFormat df = new DecimalFormat("00");
		String str = df.format(num);
		int pos = Integer.valueOf(str.substring(0, 1)) + Integer.valueOf(str.substring(1, 2));
		return Integer.valueOf(df.format(pos).substring(1, 2));
	}

	@Override
	public int getLength() {
		return 10;
	}

}
