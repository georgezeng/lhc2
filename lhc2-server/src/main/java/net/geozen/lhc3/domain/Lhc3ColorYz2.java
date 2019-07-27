package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lhc3_color_yz_2")
public class Lhc3ColorYz2 {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getTables() {
		return tables;
	}
	public void setTables(String tables) {
		this.tables = tables;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWrColor() {
		return wrColor;
	}
	public void setWrColor(String wrColor) {
		this.wrColor = wrColor;
	}
	public String getYzrColor() {
		return yzrColor;
	}
	public void setYzrColor(String yzrColor) {
		this.yzrColor = yzrColor;
	}
	public String getYzgColor() {
		return yzgColor;
	}
	public void setYzgColor(String yzgColor) {
		this.yzgColor = yzgColor;
	}
	public int getWr() {
		return wr;
	}
	public void setWr(int wr) {
		this.wr = wr;
	}
	public int getWrBase() {
		return wrBase;
	}
	public void setWrBase(int wrBase) {
		this.wrBase = wrBase;
	}
	public int getWrPos() {
		return wrPos;
	}
	public void setWrPos(int wrPos) {
		this.wrPos = wrPos;
	}
	public double getWrCost() {
		return wrCost;
	}
	public void setWrCost(double wrCost) {
		this.wrCost = wrCost;
	}
	public double getWrIncome() {
		return wrIncome;
	}
	public void setWrIncome(double wrIncome) {
		this.wrIncome = wrIncome;
	}
	public int getYzr() {
		return yzr;
	}
	public void setYzr(int yzr) {
		this.yzr = yzr;
	}
	public int getYzrBase() {
		return yzrBase;
	}
	public void setYzrBase(int yzrBase) {
		this.yzrBase = yzrBase;
	}
	public int getYzrPos() {
		return yzrPos;
	}
	public void setYzrPos(int yzrPos) {
		this.yzrPos = yzrPos;
	}
	public double getYzrCost() {
		return yzrCost;
	}
	public void setYzrCost(double yzrCost) {
		this.yzrCost = yzrCost;
	}
	public double getYzrIncome() {
		return yzrIncome;
	}
	public void setYzrIncome(double yzrIncome) {
		this.yzrIncome = yzrIncome;
	}
	public int getYzg() {
		return yzg;
	}
	public void setYzg(int yzg) {
		this.yzg = yzg;
	}
	public int getYzgBase() {
		return yzgBase;
	}
	public void setYzgBase(int yzgBase) {
		this.yzgBase = yzgBase;
	}
	public int getYzgPos() {
		return yzgPos;
	}
	public void setYzgPos(int yzgPos) {
		this.yzgPos = yzgPos;
	}
	public double getYzgCost() {
		return yzgCost;
	}
	public void setYzgCost(double yzgCost) {
		this.yzgCost = yzgCost;
	}
	public double getYzgIncome() {
		return yzgIncome;
	}
	public void setYzgIncome(double yzgIncome) {
		this.yzgIncome = yzgIncome;
	}
	public double getWrCostlt() {
		return wrCostlt;
	}
	public void setWrCostlt(double wrCostlt) {
		this.wrCostlt = wrCostlt;
	}
	public double getWrIncomelt() {
		return wrIncomelt;
	}
	public void setWrIncomelt(double wrIncomelt) {
		this.wrIncomelt = wrIncomelt;
	}
	public double getWrCostt() {
		return wrCostt;
	}
	public void setWrCostt(double wrCostt) {
		this.wrCostt = wrCostt;
	}
	public double getWrIncomet() {
		return wrIncomet;
	}
	public void setWrIncomet(double wrIncomet) {
		this.wrIncomet = wrIncomet;
	}
	public double getYzrCostlt() {
		return yzrCostlt;
	}
	public void setYzrCostlt(double yzrCostlt) {
		this.yzrCostlt = yzrCostlt;
	}
	public double getYzrIncomelt() {
		return yzrIncomelt;
	}
	public void setYzrIncomelt(double yzrIncomelt) {
		this.yzrIncomelt = yzrIncomelt;
	}
	public double getYzrCostt() {
		return yzrCostt;
	}
	public void setYzrCostt(double yzrCostt) {
		this.yzrCostt = yzrCostt;
	}
	public double getYzrIncomet() {
		return yzrIncomet;
	}
	public void setYzrIncomet(double yzrIncomet) {
		this.yzrIncomet = yzrIncomet;
	}
	public double getYzgCostlt() {
		return yzgCostlt;
	}
	public void setYzgCostlt(double yzgCostlt) {
		this.yzgCostlt = yzgCostlt;
	}
	public double getYzgIncomelt() {
		return yzgIncomelt;
	}
	public void setYzgIncomelt(double yzgIncomelt) {
		this.yzgIncomelt = yzgIncomelt;
	}
	public double getYzgCostt() {
		return yzgCostt;
	}
	public void setYzgCostt(double yzgCostt) {
		this.yzgCostt = yzgCostt;
	}
	public double getYzgIncomet() {
		return yzgIncomet;
	}
	public void setYzgIncomet(double yzgIncomet) {
		this.yzgIncomet = yzgIncomet;
	}
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
