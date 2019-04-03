package net.geozen.lhc3.domain.seqp;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.PosBaseEntity;

@Entity
@Table(name = "lhc3_seqp_yz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqpYz extends PosBaseEntity {
	
}
