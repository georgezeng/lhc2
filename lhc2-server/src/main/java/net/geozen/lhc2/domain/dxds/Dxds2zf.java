package net.geozen.lhc2.domain.dxds;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "dxds2zf")
public class Dxds2zf extends PosBaseEntity {
	private int zf0;
	private int zf1;
	private int zf2;
	private int zf3;
	private String rgColor;
	private Integer rg;

	public int getZf0() {
		return zf0;
	}

	public void setZf0(int zf0) {
		this.zf0 = zf0;
	}

	public int getZf1() {
		return zf1;
	}

	public void setZf1(int zf1) {
		this.zf1 = zf1;
	}

	public int getZf2() {
		return zf2;
	}

	public void setZf2(int zf2) {
		this.zf2 = zf2;
	}

	public int getZf3() {
		return zf3;
	}

	public void setZf3(int zf3) {
		this.zf3 = zf3;
	}

	public String getRgColor() {
		return rgColor;
	}

	public void setRgColor(String rgColor) {
		this.rgColor = rgColor;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}
}
