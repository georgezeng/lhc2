package net.geozen.lhc2.domain.slq.a;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqyz;

@Entity
@Table(name = "slqayz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqayz extends Slqyz {
}