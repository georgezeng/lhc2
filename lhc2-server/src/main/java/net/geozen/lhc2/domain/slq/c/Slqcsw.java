package net.geozen.lhc2.domain.slq.c;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqsw;

@Entity
@Table(name = "slqcsw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqcsw extends Slqsw {
}
