package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "swyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Swyz extends PosBaseEntity {
	private int w1;
	private int w2;
	private int w3;
	private int w4;
	private int w0;
}
