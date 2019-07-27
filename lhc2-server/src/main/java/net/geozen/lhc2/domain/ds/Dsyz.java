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
