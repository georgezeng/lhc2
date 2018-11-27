package net.geozen.lhc2.domain.slq.c;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqyz;

@Entity
@Table(name = "slqcyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqcyz extends Slqyz {
}
