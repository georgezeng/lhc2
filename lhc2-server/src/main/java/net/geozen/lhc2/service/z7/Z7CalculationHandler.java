package net.geozen.lhc2.service.z7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class Z7CalculationHandler implements CalculationHandler {
	private List<Integer> w1 = Arrays.asList(1, 19, 21, 39, 40);
	private List<Integer> w2 = Arrays.asList(2, 18, 22, 38, 41);
	private List<Integer> w3 = Arrays.asList(3, 17, 23, 37, 42);
	private List<Integer> w4 = Arrays.asList(4, 16, 24, 36, 43);
	private List<Integer> w5 = Arrays.asList(5, 15, 25, 35);
	private List<Integer> w6 = Arrays.asList(6, 14, 26, 34, 46);
	private List<Integer> w7 = Arrays.asList(7, 13, 27, 33, 47);
	private List<Integer> w8 = Arrays.asList(8, 12, 28, 32, 48);
	private List<Integer> w9 = Arrays.asList(9, 11, 29, 31, 45);
	private List<Integer> w10 = Arrays.asList(10, 20, 30, 44, 49);
	private List<List<Integer>> lists = new ArrayList<>();
	{
		lists.add(w1);
		lists.add(w2);
		lists.add(w3);
		lists.add(w4);
		lists.add(w5);
		lists.add(w6);
		lists.add(w7);
		lists.add(w8);
		lists.add(w9);
		lists.add(w10);
	}

	@Override
	public int getLength() {
		return 10;
	}

	@Override
	public List<List<Integer>> getLists() {
		return lists;
	}

}
