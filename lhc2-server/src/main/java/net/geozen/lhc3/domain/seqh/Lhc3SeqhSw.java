package net.geozen.lhc3.domain.seqh;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.SwBaseEntity;

@Entity
@Table(name = "lhc3_seqh_sw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqhSw extends SwBaseEntity {
	
}
