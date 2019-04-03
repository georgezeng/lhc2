package net.geozen.lhc3.domain.seqj;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.SwBaseEntity;

@Entity
@Table(name = "lhc3_seqj_sw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqjSw extends SwBaseEntity {
	
}
