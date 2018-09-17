package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "mwyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Mwyz extends PosBaseEntity {
	private int w1;
	private int w2;
	private int w3;
	private int w4;
	private int w5;
	private int w6;
	private int w7;
	private int w8;
	private int w9;
	private int w0;
}
