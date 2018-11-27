package net.geozen.lhc2.domain.slq.a;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqzf;

@Entity
@Table(name = "slqazf")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqazf extends Slqzf {
}
