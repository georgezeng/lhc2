package net.geozen.lhc3.domain.seqe;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.PosBaseEntity;

@Entity
@Table(name = "lhc3_seqe_zf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqeZf extends PosBaseEntity {
	
}
