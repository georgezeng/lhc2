package net.geozen.lhc2.domain.bs;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "bsyz")
public class Bsyz extends PosBaseEntity {
	private int red1;
	private int red2;
	private int red3;
	private int blue1;
	private int blue2;
	private int blue3;
	private int green1;
	private int green2;
	private int green3;

	public int getW0() {
		return red1;
	}

	public int getW1() {
		return red2;
	}

	public int getW2() {
		return red3;
	}

	public int getW3() {
		return blue1;
	}

	public int getW4() {
		return blue2;
	}

	public int getW5() {
		return blue3;
	}

	public int getW6() {
		return green1;
	}

	public int getW7() {
		return green2;
	}

	public int getW8() {
		return green3;
	}
}
