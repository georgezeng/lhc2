package net.geozen.lhc2.domain.sw;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "swyz")
public class Swyz extends PosBaseEntity {
	private int w1;
	private int w2;
	private int w3;
	private int w4;
	private int w0;

	public int getW1() {
		return w1;
	}

	public void setW1(int w1) {
		this.w1 = w1;
	}

	public int getW2() {
		return w2;
	}

	public void setW2(int w2) {
		this.w2 = w2;
	}

	public int getW3() {
		return w3;
	}

	public void setW3(int w3) {
		this.w3 = w3;
	}

	public int getW4() {
		return w4;
	}

	public void setW4(int w4) {
		this.w4 = w4;
	}

	public int getW0() {
		return w0;
	}

	public void setW0(int w0) {
		this.w0 = w0;
	}
}
