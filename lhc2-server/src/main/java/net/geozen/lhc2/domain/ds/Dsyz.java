package net.geozen.lhc2.domain.ds;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "dsyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Dsyz extends PosBaseEntity {
	private int odd0;
	private int even0;
	private int odd1;
	private int even1;
	private int odd2;
	private int even2;
	private int odd3;
	private int even3;
	private int odd4;
	private int even4;
}
