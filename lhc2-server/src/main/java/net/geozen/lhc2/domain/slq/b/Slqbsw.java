package net.geozen.lhc2.domain.slq.b;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqsw;

@Entity
@Table(name = "slqbsw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqbsw extends Slqsw {
}
