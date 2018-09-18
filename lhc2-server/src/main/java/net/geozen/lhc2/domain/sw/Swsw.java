package net.geozen.lhc2.domain.sw;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "swsw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Swsw extends PosBaseEntity {
	private int sw1Pos;
	private int sw2Pos;
	private int sw3Pos;
	private int sw4Pos;
	private int sw5Pos;
	private int sw1;
	private int sw2;
	private int sw3;
	private int sw4;
	private int sw5;
}
