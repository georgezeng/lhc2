package net.geozen.lhc3.domain.base;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class SwBaseEntity extends PosBaseEntity {
	private int w1Pos;
	private int w2Pos;
	private int w3Pos;
	private int w4Pos;
	private int w5Pos;
	private int w6Pos;
	private int w7Pos;
	private int w8Pos;
	private int w9Pos;
	private int w10Pos;
	private int w11Pos;
	private int w12Pos;
}
