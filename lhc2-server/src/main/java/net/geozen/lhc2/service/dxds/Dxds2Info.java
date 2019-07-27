package net.geozen.lhc2.service.dxds;

public class Dxds2Info {
	private String field;
	private Integer yz;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Integer getYz() {
		return yz;
	}

	public void setYz(Integer yz) {
		this.yz = yz;
	}

	public Dxds2Info(String field, Integer yz) {
		this.field = field;
		this.yz = yz;
	}
}
