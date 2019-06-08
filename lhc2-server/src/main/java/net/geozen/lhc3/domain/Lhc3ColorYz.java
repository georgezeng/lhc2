package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lhc3_color_yz")
@Data
public class Lhc3ColorYz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phase;
	private String tables;
	private String type;
	private String yzColor;
	private String r1Color;
	private String r2Color;
	private String r3Color;
	private String r4Color;
	private String r5Color;
	private String r6Color;
	private String r7Color;
	private String r8Color;
	private String g1Color;
	private String g2Color;
	private String g3Color;
	private String g4Color;
	private String g5Color;
	private String g6Color;
	private String g7Color;
	private String g8Color;
	private String wrColor;
	private int wr;
	private int yz;
	private int r1;
	private int r2;
	private int r3;
	private int r4;
	private int r5;
	private int r6;
	private int r7;
	private int r8;
	private int ltR1;
	private int ltR2;
	private int ltR3;
	private int ltR4;
	private int ltR5;
	private int ltR6;
	private int ltR7;
	private int ltR8;
	private int tR1;
	private int tR2;
	private int tR3;
	private int tR4;
	private int tR5;
	private int tR6;
	private int tR7;
	private int tR8;
	private int g1;
	private int g2;
	private int g3;
	private int g4;
	private int g5;
	private int g6;
	private int g7;
	private int g8;
	private int ltG1;
	private int ltG2;
	private int ltG3;
	private int ltG4;
	private int ltG5;
	private int ltG6;
	private int ltG7;
	private int ltG8;
	private int tG1;
	private int tG2;
	private int tG3;
	private int tG4;
	private int tG5;
	private int tG6;
	private int tG7;
	private int tG8;
}
