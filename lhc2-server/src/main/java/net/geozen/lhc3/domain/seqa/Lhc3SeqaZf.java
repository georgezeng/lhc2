package net.geozen.lhc3.domain.seqa;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.PosBaseEntity;

@Entity
@Table(name = "lhc3_seqa_zf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqaZf extends PosBaseEntity {
	
}
