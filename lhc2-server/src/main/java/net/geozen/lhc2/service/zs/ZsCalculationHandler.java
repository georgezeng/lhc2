package net.geozen.lhc2.service.zs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class ZsCalculationHandler implements CalculationHandler {
	private List<Integer> w0 = Arrays.asList(2, 3, 5, 7, 11);
	private List<Integer> w1 = Arrays.asList(13, 17, 19, 23, 29);
	private List<Integer> w2 = Arrays.asList(31, 37, 41, 43, 47);
	private List<Integer> w3 = Arrays.asList(1, 9, 15, 21, 25);
	private List<Integer> w4 = Arrays.asList(27, 33, 35, 39, 45, 49);
	private List<Integer> w5 = Arrays.asList(4, 6, 8, 10, 12, 14);
	private List<Integer> w6 = Arrays.asList(16, 18, 20, 22, 24, 26);
	private List<Integer> w7 = Arrays.asList(28, 30, 32, 34, 36, 38);
	private List<Integer> w8 = Arrays.asList(40, 42, 44, 46, 48);
	private List<List<Integer>> lists = new ArrayList<>();
	{
		lists.add(w0);
		lists.add(w1);
		lists.add(w2);
		lists.add(w3);
		lists.add(w4);
		lists.add(w5);
		lists.add(w6);
		lists.add(w7);
		lists.add(w8);
	}

	@Override
	public int getLength() {
		return 9;
	}

	@Override
	public List<List<Integer>> getLists() {
		return lists;
	}

}
