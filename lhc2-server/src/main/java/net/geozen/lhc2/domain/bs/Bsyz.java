package net.geozen.lhc2.domain.bs;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "bsyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Bsyz extends PosBaseEntity {
	private int red1;
	private int red2;
	private int red3;
	private int blue1;
	private int blue2;
	private int blue3;
	private int green1;
	private int green2;
	private int green3;
}
