package net.geozen.lhc3.domain.seqg;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.SwBaseEntity;

@Entity
@Table(name = "lhc3_seqg_sw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqgSw extends SwBaseEntity {
	
}
