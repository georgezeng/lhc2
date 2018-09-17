package net.geozen.lhc2.domain.seq;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "seqyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Seqyz extends PosBaseEntity {
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
}
