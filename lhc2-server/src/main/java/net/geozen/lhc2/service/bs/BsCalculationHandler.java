package net.geozen.lhc2.service.bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class BsCalculationHandler implements CalculationHandler {
	private List<Integer> red1 = Arrays.asList(1, 2, 7, 8, 12, 13);
	private List<Integer> red2 = Arrays.asList(18, 19, 23, 24, 29, 30);
	private List<Integer> red3 = Arrays.asList(34, 35, 40, 45, 46);
	private List<Integer> blue1 = Arrays.asList(5, 6, 11, 16, 17);
	private List<Integer> blue2 = Arrays.asList(21, 22, 27, 28, 32);
	private List<Integer> blue3 = Arrays.asList(33, 38, 39, 43, 44, 49);
	private List<Integer> green1 = Arrays.asList(3, 4, 9, 10, 14);
	private List<Integer> green2 = Arrays.asList(15, 20, 25, 26, 31);
	private List<Integer> green3 = Arrays.asList(36, 37, 41, 42, 47, 48);
	private List<List<Integer>> lists = new ArrayList<>();
	{
		lists.add(red1);
		lists.add(red2);
		lists.add(red3);
		lists.add(blue1);
		lists.add(blue2);
		lists.add(blue3);
		lists.add(green1);
		lists.add(green2);
		lists.add(green3);
	}

	@Override
	public int getLength() {
		return 9;
	}

	@Override
	public String getIndexStr(int index) {
		if (index < 3) {
			return "Red" + (index + 1);
		} else if (index < 6) {
			return "Blue" + (index % 3 + 1);
		} else {
			return "Green" + (index % 3 + 1);
		}
	}

	@Override
	public List<List<Integer>> getLists() {
		return lists;
	}
}
