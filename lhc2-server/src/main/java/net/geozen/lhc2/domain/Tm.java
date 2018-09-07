package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tm")
@Data
@EqualsAndHashCode(callSuper = true)
public class Tm extends BaseEntity {
}
