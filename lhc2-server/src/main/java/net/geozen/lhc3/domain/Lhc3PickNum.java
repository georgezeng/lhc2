package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lhc3_pick_num")
@Data
public class Lhc3PickNum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phase;
	private int num;
	private String payload;
	private int expected;
	private String type;
	private String time0;
	private String time1;
	private String time2;
	private String time2Plus;
	private String time3Plus;
}
