package net.geozen.lhc3.domain;

import javax.persistence.Column;
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
	@Column(name="ltr1")
	private int ltR1;
	@Column(name="ltr2")
	private int ltR2;
	@Column(name="ltr3")
	private int ltR3;
	@Column(name="ltr4")
	private int ltR4;
	@Column(name="ltr5")
	private int ltR5;
	@Column(name="ltr6")
	private int ltR6;
	@Column(name="ltr7")
	private int ltR7;
	@Column(name="ltr8")
	private int ltR8;
	@Column(name="tr1")
	private int tR1;
	@Column(name="tr2")
	private int tR2;
	@Column(name="tr3")
	private int tR3;
	@Column(name="tr4")
	private int tR4;
	@Column(name="tr5")
	private int tR5;
	@Column(name="tr6")
	private int tR6;
	@Column(name="tr7")
	private int tR7;
	@Column(name="tr8")
	private int tR8;
	private int g1;
	private int g2;
	private int g3;
	private int g4;
	private int g5;
	private int g6;
	private int g7;
	private int g8;
	@Column(name="ltg1")
	private int ltG1;
	@Column(name="ltg2")
	private int ltG2;
	@Column(name="ltg3")
	private int ltG3;
	@Column(name="ltg4")
	private int ltG4;
	@Column(name="ltg5")
	private int ltG5;
	@Column(name="ltg6")
	private int ltG6;
	@Column(name="ltg7")
	private int ltG7;
	@Column(name="ltg8")
	private int ltG8;
	@Column(name="tg1")
	private int tG1;
	@Column(name="tg2")
	private int tG2;
	@Column(name="tg3")
	private int tG3;
	@Column(name="tg4")
	private int tG4;
	@Column(name="tg5")
	private int tG5;
	@Column(name="tg6")
	private int tG6;
	@Column(name="tg7")
	private int tG7;
	@Column(name="tg8")
	private int tG8;
}
