package net.geozen.lhc3.domain.seqj;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.PosBaseEntity;

@Entity
@Table(name = "lhc3_seqj_zf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqjZf extends PosBaseEntity {
	
}
