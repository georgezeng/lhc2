package net.geozen.lhc2.service.z13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class Z13CalculationHandler implements CalculationHandler {
	private List<Integer> w1 = Arrays.asList(8, 23, 28, 38, 45);
	private List<Integer> w2 = Arrays.asList(9, 24, 29, 39);
	private List<Integer> w3 = Arrays.asList(10, 25, 30, 40);
	private List<Integer> w4 = Arrays.asList(11, 26, 41, 43);
	private List<Integer> w5 = Arrays.asList(12, 27, 42, 44);
	private List<Integer> w6 = Arrays.asList(6, 14, 21, 36);
	private List<Integer> w7 = Arrays.asList(7, 15, 22, 37);
	private List<Integer> w8 = Arrays.asList(1, 16, 31, 46);
	private List<Integer> w9 = Arrays.asList(2, 17, 32, 47);
	private List<Integer> w10 = Arrays.asList(3, 18, 33, 48);
	private List<Integer> w11 = Arrays.asList(4, 19, 34, 49);
	private List<Integer> w12 = Arrays.asList(5, 13, 20, 35);
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
		lists.add(w11);
		lists.add(w12);
	}

	@Override
	public int getLength() {
		return 12;
	}

	@Override
	public List<List<Integer>> getLists() {
		return lists;
	}

}
