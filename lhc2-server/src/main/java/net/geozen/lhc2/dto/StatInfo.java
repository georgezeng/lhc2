package net.geozen.lhc2.dto;

public class StatInfo {
	private int num;
	private int count;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public StatInfo(int num, int count) {
		this.num = num;
		this.count = count;
	}

	public StatInfo() {
		super();
	}

}
