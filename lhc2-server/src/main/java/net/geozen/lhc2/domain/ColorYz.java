package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "color_yz")
@Data
public class ColorYz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int phase;
	private String tables;
	private String yzColor;
	private String r1Color;
	private String r2Color;
	private String r3Color;
	private String r4Color;
	private String r5Color;
	private String g1Color;
	private String g2Color;
	private String g3Color;
	private String g4Color;
	private String g5Color;
	private String wrColor;
	private int wr;
	private int yz;
	private int r1;
	private int r2;
	private int r3;
	private int r4;
	private int r5;
	private int g1;
	private int g2;
	private int g3;
	private int g4;
	private int g5;
}
