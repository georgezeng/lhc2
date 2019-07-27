package net.geozen.lhc2.domain.sw;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "swzf")
public class Swzf extends PosBaseEntity {
	private int zf0;
	private int zf1;
	private int zf2;
	private int zf3;
	private int zf4;

	public int getZf0() {
		return zf0;
	}

	public void setZf0(int zf0) {
		this.zf0 = zf0;
	}

	public int getZf1() {
		return zf1;
	}

	public void setZf1(int zf1) {
		this.zf1 = zf1;
	}

	public int getZf2() {
		return zf2;
	}

	public void setZf2(int zf2) {
		this.zf2 = zf2;
	}

	public int getZf3() {
		return zf3;
	}

	public void setZf3(int zf3) {
		this.zf3 = zf3;
	}

	public int getZf4() {
		return zf4;
	}

	public void setZf4(int zf4) {
		this.zf4 = zf4;
	}
}
