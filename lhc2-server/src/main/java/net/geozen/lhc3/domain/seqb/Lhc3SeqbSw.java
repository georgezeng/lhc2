package net.geozen.lhc3.domain.seqb;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.SwBaseEntity;

@Entity
@Table(name = "lhc3_seqb_sw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqbSw extends SwBaseEntity {
	
}
