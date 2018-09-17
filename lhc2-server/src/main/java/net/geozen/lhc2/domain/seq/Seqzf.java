package net.geozen.lhc2.domain.seq;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.base.PosBaseEntity;

@Entity
@Table(name = "seqzf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Seqzf extends PosBaseEntity {
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
