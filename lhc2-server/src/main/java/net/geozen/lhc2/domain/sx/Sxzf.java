package net.geozen.lhc2.domain.sx;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.SxBaseEntity;

@Entity
@Table(name = "sxzf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Sxzf extends SxBaseEntity {
	private int zf0;
	private int zf1;
	private int zf2;
	private int zf3;
	private int zf4;
	private int zf5;
	private int zf6;
	private int zf7;
	private int zf8;
	private int zf9;
	private int zf10;
	private int zf11;
}
