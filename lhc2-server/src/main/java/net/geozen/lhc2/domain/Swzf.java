package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "swzf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Swzf extends PosBaseEntity {
	private int zf0;
	private int zf1;
	private int zf2;
	private int zf3;
	private int zf4;
}
