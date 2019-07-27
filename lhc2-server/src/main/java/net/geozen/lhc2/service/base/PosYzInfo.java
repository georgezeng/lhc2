package net.geozen.lhc2.service.base;

public class PosYzInfo {
	private Integer pos;
	private Integer yz;

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public Integer getYz() {
		return yz;
	}

	public void setYz(Integer yz) {
		this.yz = yz;
	}

	public PosYzInfo(Integer pos, Integer yz) {
		super();
		this.pos = pos;
		this.yz = yz;
	}
}
