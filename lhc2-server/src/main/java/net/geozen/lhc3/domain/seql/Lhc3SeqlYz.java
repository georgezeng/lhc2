package net.geozen.lhc3.domain.seql;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.PosBaseEntity;

@Entity
@Table(name = "lhc3_seql_yz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3SeqlYz extends PosBaseEntity {
	
}
