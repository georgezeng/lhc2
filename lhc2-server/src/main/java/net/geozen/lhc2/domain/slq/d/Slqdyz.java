package net.geozen.lhc2.domain.slq.d;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqyz;

@Entity
@Table(name = "slqdyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqdyz extends Slqyz {
}
