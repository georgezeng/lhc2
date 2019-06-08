package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lhc3_times_yz")
@Data
public class Lhc3TimesYz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phase;
	private String tables;
	private String type;
	private int time12;
	private int time2Plus;
	private int time03Plus;
	private int num;
	private int lt12;
	private int lt2Plus;
	private int lt03Plus;
	private int t12;
	private int t2Plus;
	private int t03Plus;
}
