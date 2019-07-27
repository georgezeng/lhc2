package net.geozen.lhc2.domain.base;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PosBaseEntity extends BaseEntity {
	private int pos;

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
}
