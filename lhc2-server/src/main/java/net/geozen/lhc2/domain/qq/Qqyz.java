package net.geozen.lhc2.domain.qq;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "qqyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Qqyz extends PosBaseEntity {
	private int w0;
	private int w1;
	private int w2;
	private int w3;
	private int w4;
	private int w5;
	private int w6;
}
