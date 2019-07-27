package net.geozen.lhc2.domain.base;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import net.geozen.lhc2.enums.SX;

@MappedSuperclass
public abstract class SxBaseEntity extends BaseEntity {
	@Enumerated(EnumType.STRING)
	private SX sx;

	public SX getSx() {
		return sx;
	}

	public void setSx(SX sx) {
		this.sx = sx;
	}
}
