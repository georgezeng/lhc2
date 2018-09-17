package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "swsw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Swsw extends PosBaseEntity {
	private int sw1;
	private int sw2;
	private int sw3;
	private int sw4;
	private int sw5;
}
