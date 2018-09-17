package net.geozen.lhc2.domain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.enums.SX;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class SxBaseEntity extends BaseEntity {
	@Enumerated(EnumType.STRING)
	private SX sx;
}
