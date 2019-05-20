package net.geozen.lhc2.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ZInfo {
	private int order;
	private BigDecimal z;
	private BigDecimal zForP1;
	private List<Integer> nums;
	private List<Integer> numsForD1;
	private List<Integer> numsForD2;
	private List<Integer> numsForS2;
	private List<Integer> minNums;
}
