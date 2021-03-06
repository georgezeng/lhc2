package net.geozen.lhc2.domain.sw;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "swsw")
public class Swsw extends PosBaseEntity {
	private int sw1Pos;
	private int sw2Pos;
	private int sw3Pos;
	private int sw4Pos;
	private int sw5Pos;
	private int sw1;
	private int sw2;
	private int sw3;
	private int sw4;
	private int sw5;

	public int getSw1Pos() {
		return sw1Pos;
	}

	public void setSw1Pos(int sw1Pos) {
		this.sw1Pos = sw1Pos;
	}

	public int getSw2Pos() {
		return sw2Pos;
	}

	public void setSw2Pos(int sw2Pos) {
		this.sw2Pos = sw2Pos;
	}

	public int getSw3Pos() {
		return sw3Pos;
	}

	public void setSw3Pos(int sw3Pos) {
		this.sw3Pos = sw3Pos;
	}

	public int getSw4Pos() {
		return sw4Pos;
	}

	public void setSw4Pos(int sw4Pos) {
		this.sw4Pos = sw4Pos;
	}

	public int getSw5Pos() {
		return sw5Pos;
	}

	public void setSw5Pos(int sw5Pos) {
		this.sw5Pos = sw5Pos;
	}

	public int getSw1() {
		return sw1;
	}

	public void setSw1(int sw1) {
		this.sw1 = sw1;
	}

	public int getSw2() {
		return sw2;
	}

	public void setSw2(int sw2) {
		this.sw2 = sw2;
	}

	public int getSw3() {
		return sw3;
	}

	public void setSw3(int sw3) {
		this.sw3 = sw3;
	}

	public int getSw4() {
		return sw4;
	}

	public void setSw4(int sw4) {
		this.sw4 = sw4;
	}

	public int getSw5() {
		return sw5;
	}

	public void setSw5(int sw5) {
		this.sw5 = sw5;
	}
}
