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

	public int getRed1() {
		return red1;
	}

	public void setRed1(int red1) {
		this.red1 = red1;
	}

	public int getRed2() {
		return red2;
	}

	public void setRed2(int red2) {
		this.red2 = red2;
	}

	public int getRed3() {
		return red3;
	}

	public void setRed3(int red3) {
		this.red3 = red3;
	}

	public int getBlue1() {
		return blue1;
	}

	public void setBlue1(int blue1) {
		this.blue1 = blue1;
	}

	public int getBlue2() {
		return blue2;
	}

	public void setBlue2(int blue2) {
		this.blue2 = blue2;
	}

	public int getBlue3() {
		return blue3;
	}

	public void setBlue3(int blue3) {
		this.blue3 = blue3;
	}

	public int getGreen1() {
		return green1;
	}

	public void setGreen1(int green1) {
		this.green1 = green1;
	}

	public int getGreen2() {
		return green2;
	}

	public void setGreen2(int green2) {
		this.green2 = green2;
	}

	public int getGreen3() {
		return green3;
	}

	public void setGreen3(int green3) {
		this.green3 = green3;
	}

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
