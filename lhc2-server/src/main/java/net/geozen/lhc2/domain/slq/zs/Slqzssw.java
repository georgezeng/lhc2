package net.geozen.lhc2.domain.slq.zs;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc2.domain.slq.Slqsw;

@Entity
@Table(name = "slqzssw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Slqzssw extends Slqsw {
}
