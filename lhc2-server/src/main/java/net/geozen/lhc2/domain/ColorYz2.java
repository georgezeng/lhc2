package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "color_yz_2")
public class ColorYz2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int phase;
	private String tables;
	private String type;
	private String wrColor;
	private String yzrColor;
	private String yzgColor;
	private int wr;
	private int wrBase;
	private int wrPos;
	private int yzr;
	private int yzrBase;
	private int yzrPos;
	private int yzg;
	private int yzgBase;
	private int yzgPos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
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
}
