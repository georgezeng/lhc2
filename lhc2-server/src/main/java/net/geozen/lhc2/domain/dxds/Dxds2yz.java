package net.geozen.lhc2.domain.dxds;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "dxds2yz")
public class Dxds2yz extends PosBaseEntity {
	private int smallOdd;
	private int smallEven;
	private int largeOdd;
	private int largeEven;
	private String rgColor;
	private Integer rg;

	public int getSmallOdd() {
		return smallOdd;
	}

	public void setSmallOdd(int smallOdd) {
		this.smallOdd = smallOdd;
	}

	public int getSmallEven() {
		return smallEven;
	}

	public void setSmallEven(int smallEven) {
		this.smallEven = smallEven;
	}

	public int getLargeOdd() {
		return largeOdd;
	}

	public void setLargeOdd(int largeOdd) {
		this.largeOdd = largeOdd;
	}

	public int getLargeEven() {
		return largeEven;
	}

	public void setLargeEven(int largeEven) {
		this.largeEven = largeEven;
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
