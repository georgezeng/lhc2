package net.geozen.lhc2.service.pd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import net.geozen.lhc2.service.base.CalculationHandler;

@Component
public class PdCalculationHandler implements CalculationHandler {
	private List<Integer> w0 = Arrays.asList(1, 38, 39, 42);
	private List<Integer> w1 = Arrays.asList(2, 4, 8, 16, 32);
	private List<Integer> w2 = Arrays.asList(3, 9, 27, 45);
	private List<Integer> w3 = Arrays.asList(5, 15, 25, 35);
	private List<Integer> w4 = Arrays.asList(6, 12, 24, 48);
	private List<Integer> w5 = Arrays.asList(7, 21, 26, 49);
	private List<Integer> w6 = Arrays.asList(10, 20, 30, 40);
	private List<Integer> w7 = Arrays.asList(11, 22, 33, 44);
	private List<Integer> w8 = Arrays.asList(13, 17, 31, 47);
	private List<Integer> w9 = Arrays.asList(14, 34, 41, 43);
	private List<Integer> w10 = Arrays.asList(18, 23, 29, 46);
	private List<Integer> w11 = Arrays.asList(19, 28, 36, 37);
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
		lists.add(w9);
		lists.add(w10);
		lists.add(w11);
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
