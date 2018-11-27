package net.geozen.lhc2.domain.slq.bs;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqyz;

@Entity
@Table(name = "slqbsyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqbsyz extends Slqyz {
}
