package net.geozen.lhc2.service.base;

import net.geozen.lhc2.enums.SX;

public class SxYzInfo {
	private SX sx;
	private int yz;

	public SxYzInfo(SX sx, int yz) {
		super();
		this.sx = sx;
		this.yz = yz;
	}

	public SX getSx() {
		return sx;
	}

	public void setSx(SX sx) {
		this.sx = sx;
	}

	public int getYz() {
		return yz;
	}

	public void setYz(int yz) {
		this.yz = yz;
	}
}
