package net.geozen.lhc2.service.base;

public interface CalculationHandler {
	int getPos(int num);

	int getLength();

	default String getIndexStr(int index) {
		return "W" + index;
	}
}
