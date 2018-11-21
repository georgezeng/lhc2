package net.geozen.lhc2.domain.dxds;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "dxds2zf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Dxds2zf extends PosBaseEntity {
	private int zf0;
	private int zf1;
	private int zf2;
	private int zf3;
	private String rgColor;
	private Integer rg;
}
