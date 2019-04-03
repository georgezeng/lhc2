package net.geozen.lhc3.domain.seqi;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.SwBaseEntity;

@Entity
@Table(name = "lhc3_seqi_sw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqiSw extends SwBaseEntity {
	
}
