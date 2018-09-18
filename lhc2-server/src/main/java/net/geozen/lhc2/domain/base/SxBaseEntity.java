package net.geozen.lhc2.domain.base;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.enums.SX;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class SxBaseEntity extends BaseEntity {
	@Enumerated(EnumType.STRING)
	private SX sx;
}
