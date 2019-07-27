package net.geozen.lhc2.domain.sx;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import net.geozen.lhc2.domain.base.SxBaseEntity;
import net.geozen.lhc2.enums.SX;

@Entity
@Table(name = "sxsw")
public class Sxsw extends SxBaseEntity {
	@Enumerated(EnumType.STRING)
	private SX sw1sx;
	@Enumerated(EnumType.STRING)
	private SX sw2sx;
	@Enumerated(EnumType.STRING)
	private SX sw3sx;
	@Enumerated(EnumType.STRING)
	private SX sw4sx;
	@Enumerated(EnumType.STRING)
	private SX sw5sx;
	@Enumerated(EnumType.STRING)
	private SX sw6sx;
	@Enumerated(EnumType.STRING)
	private SX sw7sx;
	@Enumerated(EnumType.STRING)
	private SX sw8sx;
	@Enumerated(EnumType.STRING)
	private SX sw9sx;
	@Enumerated(EnumType.STRING)
	private SX sw10sx;
	@Enumerated(EnumType.STRING)
	private SX sw11sx;
	@Enumerated(EnumType.STRING)
	private SX sw12sx;
	private int sw1;
	private int sw2;
	private int sw3;
	private int sw4;
	private int sw5;
	private int sw6;
	private int sw7;
	private int sw8;
	private int sw9;
	private int sw10;
	private int sw11;
	private int sw12;

	public SX getSw1sx() {
		return sw1sx;
	}

	public void setSw1sx(SX sw1sx) {
		this.sw1sx = sw1sx;
	}

	public SX getSw2sx() {
		return sw2sx;
	}

	public void setSw2sx(SX sw2sx) {
		this.sw2sx = sw2sx;
	}

	public SX getSw3sx() {
		return sw3sx;
	}

	public void setSw3sx(SX sw3sx) {
		this.sw3sx = sw3sx;
	}

	public SX getSw4sx() {
		return sw4sx;
	}

	public void setSw4sx(SX sw4sx) {
		this.sw4sx = sw4sx;
	}

	public SX getSw5sx() {
		return sw5sx;
	}

	public void setSw5sx(SX sw5sx) {
		this.sw5sx = sw5sx;
	}

	public SX getSw6sx() {
		return sw6sx;
	}

	public void setSw6sx(SX sw6sx) {
		this.sw6sx = sw6sx;
	}

	public SX getSw7sx() {
		return sw7sx;
	}

	public void setSw7sx(SX sw7sx) {
		this.sw7sx = sw7sx;
	}

	public SX getSw8sx() {
		return sw8sx;
	}

	public void setSw8sx(SX sw8sx) {
		this.sw8sx = sw8sx;
	}

	public SX getSw9sx() {
		return sw9sx;
	}

	public void setSw9sx(SX sw9sx) {
		this.sw9sx = sw9sx;
	}

	public SX getSw10sx() {
		return sw10sx;
	}

	public void setSw10sx(SX sw10sx) {
		this.sw10sx = sw10sx;
	}

	public SX getSw11sx() {
		return sw11sx;
	}

	public void setSw11sx(SX sw11sx) {
		this.sw11sx = sw11sx;
	}

	public SX getSw12sx() {
		return sw12sx;
	}

	public void setSw12sx(SX sw12sx) {
		this.sw12sx = sw12sx;
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

	public int getSw6() {
		return sw6;
	}

	public void setSw6(int sw6) {
		this.sw6 = sw6;
	}

	public int getSw7() {
		return sw7;
	}

	public void setSw7(int sw7) {
		this.sw7 = sw7;
	}

	public int getSw8() {
		return sw8;
	}

	public void setSw8(int sw8) {
		this.sw8 = sw8;
	}

	public int getSw9() {
		return sw9;
	}

	public void setSw9(int sw9) {
		this.sw9 = sw9;
	}

	public int getSw10() {
		return sw10;
	}

	public void setSw10(int sw10) {
		this.sw10 = sw10;
	}

	public int getSw11() {
		return sw11;
	}

	public void setSw11(int sw11) {
		this.sw11 = sw11;
	}

	public int getSw12() {
		return sw12;
	}

	public void setSw12(int sw12) {
		this.sw12 = sw12;
	}
}
