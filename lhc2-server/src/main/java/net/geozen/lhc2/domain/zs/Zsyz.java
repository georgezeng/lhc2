package net.geozen.lhc2.domain.zs;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "zsyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Zsyz extends PosBaseEntity {
	private int w0;
	private int w1;
	private int w2;
	private int w3;
	private int w4;
	private int w5;
	private int w6;
	private int w7;
	private int w8;
}
