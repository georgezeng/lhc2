package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.BaseEntity;

@Entity
@Table(name = "lhc3_tm")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3Tm extends BaseEntity {
}