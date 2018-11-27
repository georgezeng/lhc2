package net.geozen.lhc2.domain.slq.b;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqyz;

@Entity
@Table(name = "slqbyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqbyz extends Slqyz {
}
