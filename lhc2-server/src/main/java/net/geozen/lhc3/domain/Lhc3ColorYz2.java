package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lhc3_color_yz_2")
@Data
public class Lhc3ColorYz2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phase;
	private String tables;
	private String type;
	private String wrColor;
	private String yzrColor;
	private String yzgColor;
	private int wr;
	private int wrBase;
	private int wrPos;
	private double wrCost;
	private double wrIncome;
	private int yzr;
	private int yzrBase;
	private int yzrPos;
	private double yzrCost;
	private double yzrIncome;
	private int yzg;
	private int yzgBase;
	private int yzgPos;
	private double yzgCost;
	private double yzgIncome;
	private double wrCostlt;
	private double wrIncomelt;
	private double wrCostt;
	private double wrIncomet;
	private double yzrCostlt;
	private double yzrIncomelt;
	private double yzrCostt;
	private double yzrIncomet;
	private double yzgCostlt;
	private double yzgIncomelt;
	private double yzgCostt;
	private double yzgIncomet;
}
