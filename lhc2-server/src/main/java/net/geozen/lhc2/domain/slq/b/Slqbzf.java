package net.geozen.lhc2.domain.slq.b;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqzf;

@Entity
@Table(name = "slqbzf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqbzf extends Slqzf {
}
