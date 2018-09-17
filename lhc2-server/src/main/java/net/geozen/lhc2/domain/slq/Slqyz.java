package net.geozen.lhc2.domain.slq;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "slqyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqyz extends PosBaseEntity {
	private int w0;
	private int w1;
	private int w2;
	private int w3;
	private int w4;
	private int w5;
	private int w6;
	private int w7;
	private int w8;
	private int w9;
	private int w10;
	private int w11;
	private int w12;
	private int w13;
	private int w14;
	private int w15;
}
