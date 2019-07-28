package net.geozen.lhc2.domain.ds;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "dsyz")
public class Dsyz extends PosBaseEntity {
	private int odd0;
	private int even0;
	private int odd1;
	private int even1;
	private int odd2;
	private int even2;
	private int odd3;
	private int even3;
	private int odd4;
	private int even4;

	public int getOdd0() {
		return odd0;
	}

	public void setOdd0(int odd0) {
		this.odd0 = odd0;
	}

	public int getEven0() {
		return even0;
	}

	public void setEven0(int even0) {
		this.even0 = even0;
	}

	public int getOdd1() {
		return odd1;
	}

	public void setOdd1(int odd1) {
		this.odd1 = odd1;
	}

	public int getEven1() {
		return even1;
	}

	public void setEven1(int even1) {
		this.even1 = even1;
	}

	public int getOdd2() {
		return odd2;
	}

	public void setOdd2(int odd2) {
		this.odd2 = odd2;
	}

	public int getEven2() {
		return even2;
	}

	public void setEven2(int even2) {
		this.even2 = even2;
	}

	public int getOdd3() {
		return odd3;
	}

	public void setOdd3(int odd3) {
		this.odd3 = odd3;
	}

	public int getEven3() {
		return even3;
	}

	public void setEven3(int even3) {
		this.even3 = even3;
	}

	public int getOdd4() {
		return odd4;
	}

	public void setOdd4(int odd4) {
		this.odd4 = odd4;
	}

	public int getEven4() {
		return even4;
	}

	public void setEven4(int even4) {
		this.even4 = even4;
	}

	public int getW0() {
		return odd0;
	}

	public int getW1() {
		return even0;
	}

	public int getW2() {
		return odd1;
	}

	public int getW3() {
		return even1;
	}

	public int getW4() {
		return odd2;
	}

	public int getW5() {
		return even2;
	}

	public int getW6() {
		return odd3;
	}

	public int getW7() {
		return even3;
	}

	public int getW8() {
		return odd4;
	}

	public int getW9() {
		return even4;
	}
}
