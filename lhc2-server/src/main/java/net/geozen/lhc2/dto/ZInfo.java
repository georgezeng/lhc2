package net.geozen.lhc2.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ZInfo {
	private int order;
	private BigDecimal z;
	private List<Integer> nums;
	private List<Integer> minNums;
}
