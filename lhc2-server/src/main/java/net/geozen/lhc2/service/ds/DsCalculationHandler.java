package net.geozen.lhc2.service.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class DsCalculationHandler implements CalculationHandler {
	private List<Integer> odd0 = Arrays.asList(1, 3, 5, 7, 9);
	private List<Integer> even0 = Arrays.asList(2, 4, 6, 8);
	private List<Integer> odd1 = Arrays.asList(11, 13, 15, 17, 19);
	private List<Integer> even1 = Arrays.asList(10, 12, 14, 16, 18);
	private List<Integer> odd2 = Arrays.asList(21, 23, 25, 27, 29);
	private List<Integer> even2 = Arrays.asList(20, 22, 24, 26, 28);
	private List<Integer> odd3 = Arrays.asList(31, 33, 35, 37, 39);
	private List<Integer> even3 = Arrays.asList(30, 32, 34, 36, 38);
	private List<Integer> odd4 = Arrays.asList(41, 43, 45, 47, 49);
	private List<Integer> even4 = Arrays.asList(40, 42, 44, 46, 48);
	private List<List<Integer>> lists = new ArrayList<>();
	{
		lists.add(odd0);
		lists.add(even0);
		lists.add(odd1);
		lists.add(even1);
		lists.add(odd2);
		lists.add(even2);
		lists.add(odd3);
		lists.add(even3);
		lists.add(odd4);
		lists.add(even4);
	}

	@Override
	public int getLength() {
		return 10;
	}

	@Override
	public String getIndexStr(int index) {
		switch (index) {
		case 0:
			return "Odd0";
		case 1:
			return "Even0";
		case 2:
			return "Odd1";
		case 3:
			return "Even1";
		case 4:
			return "Odd2";
		case 5:
			return "Even2";
		case 6:
			return "Odd3";
		case 7:
			return "Even3";
		case 8:
			return "Odd4";
		case 9:
			return "Even4";
		default:
			throw new RuntimeException("index[" + index + "]有误");
		}
	}

	@Override
	public List<List<Integer>> getLists() {
		return lists;
	}
}
