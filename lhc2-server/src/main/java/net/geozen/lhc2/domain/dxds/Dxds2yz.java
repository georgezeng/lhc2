package net.geozen.lhc2.domain.dxds;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "dxds2yz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Dxds2yz extends PosBaseEntity {
	private int smallOdd;
	private int smallEven;
	private int largeOdd;
	private int largeEven;
	private String rgColor;
	private Integer rg;
}
