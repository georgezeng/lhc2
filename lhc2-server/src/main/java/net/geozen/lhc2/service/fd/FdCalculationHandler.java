package net.geozen.lhc2.service.fd;

import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class FdCalculationHandler implements CalculationHandler {
	@Override
	public int getPos(int num) {
		return num - 1;
	}

	@Override
	public int getLength() {
		return 49;
	}

	@Override
	public List<List<Integer>> getLists() {
		return null;
	}

	@Override
	public String getIndexStr(int index) {
		return "Num" + (index + 1);
	}

}
