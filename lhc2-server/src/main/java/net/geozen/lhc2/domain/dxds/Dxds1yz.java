package net.geozen.lhc2.domain.dxds;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "dxds1yz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Dxds1yz extends PosBaseEntity {
	private int small;
	private int large;
	private int odd;
	private int even;

}
