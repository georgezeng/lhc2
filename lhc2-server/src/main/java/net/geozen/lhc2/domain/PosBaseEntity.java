package net.geozen.lhc2.domain;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class PosBaseEntity extends BaseEntity {
	private int pos;
}
