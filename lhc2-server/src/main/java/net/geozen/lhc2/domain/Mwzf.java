package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "mwzf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Mwzf extends PosBaseEntity {
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
}
