package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.enums.SX;

@Entity
@Table(name = "sxsw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Sxsw extends BaseEntity {
	@Enumerated(EnumType.STRING)
	private SX sw1sx;
	@Enumerated(EnumType.STRING)
	private SX sw2sx;
	@Enumerated(EnumType.STRING)
	private SX sw3sx;
	@Enumerated(EnumType.STRING)
	private SX sw4sx;
	@Enumerated(EnumType.STRING)
	private SX sw5sx;
	@Enumerated(EnumType.STRING)
	private SX sw6sx;
	@Enumerated(EnumType.STRING)
	private SX sw7sx;
	@Enumerated(EnumType.STRING)
	private SX sw8sx;
	@Enumerated(EnumType.STRING)
	private SX sw9sx;
	@Enumerated(EnumType.STRING)
	private SX sw10sx;
	@Enumerated(EnumType.STRING)
	private SX sw11sx;
	@Enumerated(EnumType.STRING)
	private SX sw12sx;
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
