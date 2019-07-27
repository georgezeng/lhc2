package net.geozen.lhc3.service.base;

import lombok.Data;

public class TempInfo {
	private int pos;
	private Integer value;
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
}
