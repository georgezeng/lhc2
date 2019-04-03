package net.geozen.lhc3.domain.seqr;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.PosBaseEntity;

@Entity
@Table(name = "lhc3_seqr_yz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqrYz extends PosBaseEntity {
	
}
