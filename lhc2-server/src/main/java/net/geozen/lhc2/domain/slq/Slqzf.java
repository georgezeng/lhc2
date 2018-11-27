package net.geozen.lhc2.domain.slq;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class Slqzf extends PosBaseEntity {
	private int zf0;
	private int zf1;
	private int zf2;
	private int zf3;
	private int zf4;
	private int zf5;
	private int zf6;
	private int zf7;
	private int zf8;
	private int zf9;
	private int zf10;
	private int zf11;
	private int zf12;
	private int zf13;
	private int zf14;
	private int zf15;
}
