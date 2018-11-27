package net.geozen.lhc2.domain.slq.bs;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqzf;

@Entity
@Table(name = "slqbszf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqbszf extends Slqzf {
}
