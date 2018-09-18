package net.geozen.lhc2.domain.mw;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "mwsw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Mwsw extends PosBaseEntity {
	private int sw1Pos;
	private int sw2Pos;
	private int sw3Pos;
	private int sw4Pos;
	private int sw5Pos;
	private int sw6Pos;
	private int sw7Pos;
	private int sw8Pos;
	private int sw9Pos;
	private int sw10Pos;
	private int sw1;
	private int sw2;
	private int sw3;
	private int sw4;
	private int sw5;
	private int sw6;
	private int sw7;
	private int sw8;
	private int sw9;
	private int sw10;
}
