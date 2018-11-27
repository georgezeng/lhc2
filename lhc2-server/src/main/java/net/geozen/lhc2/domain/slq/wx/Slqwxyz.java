package net.geozen.lhc2.domain.slq.wx;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqyz;

@Entity
@Table(name = "slqwxyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqwxyz extends Slqyz {
}
