package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "swyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Swyz extends BaseEntity {
	private Integer w1;
	private Integer w2;
	private Integer w3;
	private Integer w4;
	private Integer w0;
}
