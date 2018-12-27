package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "times_yz")
@Data
public class TimesYz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int phase;
	private String tables;
	private String type;
	private int time0;
	private int time12;
	private int time3Plus;
	private int zf0;
	private int zf1;
	private int zf2;
	private int num;
	private int pos;
}
