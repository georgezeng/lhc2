package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "sxyz")
@Data
@EqualsAndHashCode(callSuper = true)
public class Sxyz extends BaseEntity {
	private int shu;
	private int niu;
	private int hu;
	private int tu;
	private int lonng;
	private int she;
	private int ma;
	private int yang;
	private int hou;
	private int ji;
	private int gou;
	private int zhu;
}
