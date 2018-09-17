package net.geozen.lhc2.domain.seq;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "seqsw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Seqsw extends PosBaseEntity {
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
	private int sw11;
	private int sw12;
}
