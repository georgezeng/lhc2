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
	private int time0 = 1;
	private int time12 = 1;
	private int time3Plus = 1;
}
