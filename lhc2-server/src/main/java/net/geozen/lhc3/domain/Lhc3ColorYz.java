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
public class Lhc3ColorYz {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getTables() {
		return tables;
	}
	public void setTables(String tables) {
		this.tables = tables;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYzColor() {
		return yzColor;
	}
	public void setYzColor(String yzColor) {
		this.yzColor = yzColor;
	}
	public String getR1Color() {
		return r1Color;
	}
	public void setR1Color(String r1Color) {
		this.r1Color = r1Color;
	}
	public String getR2Color() {
		return r2Color;
	}
	public void setR2Color(String r2Color) {
		this.r2Color = r2Color;
	}
	public String getR3Color() {
		return r3Color;
	}
	public void setR3Color(String r3Color) {
		this.r3Color = r3Color;
	}
	public String getR4Color() {
		return r4Color;
	}
	public void setR4Color(String r4Color) {
		this.r4Color = r4Color;
	}
	public String getR5Color() {
		return r5Color;
	}
	public void setR5Color(String r5Color) {
		this.r5Color = r5Color;
	}
	public String getR6Color() {
		return r6Color;
	}
	public void setR6Color(String r6Color) {
		this.r6Color = r6Color;
	}
	public String getR7Color() {
		return r7Color;
	}
	public void setR7Color(String r7Color) {
		this.r7Color = r7Color;
	}
	public String getR8Color() {
		return r8Color;
	}
	public void setR8Color(String r8Color) {
		this.r8Color = r8Color;
	}
	public String getG1Color() {
		return g1Color;
	}
	public void setG1Color(String g1Color) {
		this.g1Color = g1Color;
	}
	public String getG2Color() {
		return g2Color;
	}
	public void setG2Color(String g2Color) {
		this.g2Color = g2Color;
	}
	public String getG3Color() {
		return g3Color;
	}
	public void setG3Color(String g3Color) {
		this.g3Color = g3Color;
	}
	public String getG4Color() {
		return g4Color;
	}
	public void setG4Color(String g4Color) {
		this.g4Color = g4Color;
	}
	public String getG5Color() {
		return g5Color;
	}
	public void setG5Color(String g5Color) {
		this.g5Color = g5Color;
	}
	public String getG6Color() {
		return g6Color;
	}
	public void setG6Color(String g6Color) {
		this.g6Color = g6Color;
	}
	public String getG7Color() {
		return g7Color;
	}
	public void setG7Color(String g7Color) {
		this.g7Color = g7Color;
	}
	public String getG8Color() {
		return g8Color;
	}
	public void setG8Color(String g8Color) {
		this.g8Color = g8Color;
	}
	public String getWrColor() {
		return wrColor;
	}
	public void setWrColor(String wrColor) {
		this.wrColor = wrColor;
	}
	public int getWr() {
		return wr;
	}
	public void setWr(int wr) {
		this.wr = wr;
	}
	public int getYz() {
		return yz;
	}
	public void setYz(int yz) {
		this.yz = yz;
	}
	public int getR1() {
		return r1;
	}
	public void setR1(int r1) {
		this.r1 = r1;
	}
	public int getR2() {
		return r2;
	}
	public void setR2(int r2) {
		this.r2 = r2;
	}
	public int getR3() {
		return r3;
	}
	public void setR3(int r3) {
		this.r3 = r3;
	}
	public int getR4() {
		return r4;
	}
	public void setR4(int r4) {
		this.r4 = r4;
	}
	public int getR5() {
		return r5;
	}
	public void setR5(int r5) {
		this.r5 = r5;
	}
	public int getR6() {
		return r6;
	}
	public void setR6(int r6) {
		this.r6 = r6;
	}
	public int getR7() {
		return r7;
	}
	public void setR7(int r7) {
		this.r7 = r7;
	}
	public int getR8() {
		return r8;
	}
	public void setR8(int r8) {
		this.r8 = r8;
	}
	public int getLtR1() {
		return ltR1;
	}
	public void setLtR1(int ltR1) {
		this.ltR1 = ltR1;
	}
	public int getLtR2() {
		return ltR2;
	}
	public void setLtR2(int ltR2) {
		this.ltR2 = ltR2;
	}
	public int getLtR3() {
		return ltR3;
	}
	public void setLtR3(int ltR3) {
		this.ltR3 = ltR3;
	}
	public int getLtR4() {
		return ltR4;
	}
	public void setLtR4(int ltR4) {
		this.ltR4 = ltR4;
	}
	public int getLtR5() {
		return ltR5;
	}
	public void setLtR5(int ltR5) {
		this.ltR5 = ltR5;
	}
	public int getLtR6() {
		return ltR6;
	}
	public void setLtR6(int ltR6) {
		this.ltR6 = ltR6;
	}
	public int getLtR7() {
		return ltR7;
	}
	public void setLtR7(int ltR7) {
		this.ltR7 = ltR7;
	}
	public int getLtR8() {
		return ltR8;
	}
	public void setLtR8(int ltR8) {
		this.ltR8 = ltR8;
	}
	public int gettR1() {
		return tR1;
	}
	public void settR1(int tR1) {
		this.tR1 = tR1;
	}
	public int gettR2() {
		return tR2;
	}
	public void settR2(int tR2) {
		this.tR2 = tR2;
	}
	public int gettR3() {
		return tR3;
	}
	public void settR3(int tR3) {
		this.tR3 = tR3;
	}
	public int gettR4() {
		return tR4;
	}
	public void settR4(int tR4) {
		this.tR4 = tR4;
	}
	public int gettR5() {
		return tR5;
	}
	public void settR5(int tR5) {
		this.tR5 = tR5;
	}
	public int gettR6() {
		return tR6;
	}
	public void settR6(int tR6) {
		this.tR6 = tR6;
	}
	public int gettR7() {
		return tR7;
	}
	public void settR7(int tR7) {
		this.tR7 = tR7;
	}
	public int gettR8() {
		return tR8;
	}
	public void settR8(int tR8) {
		this.tR8 = tR8;
	}
	public int getG1() {
		return g1;
	}
	public void setG1(int g1) {
		this.g1 = g1;
	}
	public int getG2() {
		return g2;
	}
	public void setG2(int g2) {
		this.g2 = g2;
	}
	public int getG3() {
		return g3;
	}
	public void setG3(int g3) {
		this.g3 = g3;
	}
	public int getG4() {
		return g4;
	}
	public void setG4(int g4) {
		this.g4 = g4;
	}
	public int getG5() {
		return g5;
	}
	public void setG5(int g5) {
		this.g5 = g5;
	}
	public int getG6() {
		return g6;
	}
	public void setG6(int g6) {
		this.g6 = g6;
	}
	public int getG7() {
		return g7;
	}
	public void setG7(int g7) {
		this.g7 = g7;
	}
	public int getG8() {
		return g8;
	}
	public void setG8(int g8) {
		this.g8 = g8;
	}
	public int getLtG1() {
		return ltG1;
	}
	public void setLtG1(int ltG1) {
		this.ltG1 = ltG1;
	}
	public int getLtG2() {
		return ltG2;
	}
	public void setLtG2(int ltG2) {
		this.ltG2 = ltG2;
	}
	public int getLtG3() {
		return ltG3;
	}
	public void setLtG3(int ltG3) {
		this.ltG3 = ltG3;
	}
	public int getLtG4() {
		return ltG4;
	}
	public void setLtG4(int ltG4) {
		this.ltG4 = ltG4;
	}
	public int getLtG5() {
		return ltG5;
	}
	public void setLtG5(int ltG5) {
		this.ltG5 = ltG5;
	}
	public int getLtG6() {
		return ltG6;
	}
	public void setLtG6(int ltG6) {
		this.ltG6 = ltG6;
	}
	public int getLtG7() {
		return ltG7;
	}
	public void setLtG7(int ltG7) {
		this.ltG7 = ltG7;
	}
	public int getLtG8() {
		return ltG8;
	}
	public void setLtG8(int ltG8) {
		this.ltG8 = ltG8;
	}
	public int gettG1() {
		return tG1;
	}
	public void settG1(int tG1) {
		this.tG1 = tG1;
	}
	public int gettG2() {
		return tG2;
	}
	public void settG2(int tG2) {
		this.tG2 = tG2;
	}
	public int gettG3() {
		return tG3;
	}
	public void settG3(int tG3) {
		this.tG3 = tG3;
	}
	public int gettG4() {
		return tG4;
	}
	public void settG4(int tG4) {
		this.tG4 = tG4;
	}
	public int gettG5() {
		return tG5;
	}
	public void settG5(int tG5) {
		this.tG5 = tG5;
	}
	public int gettG6() {
		return tG6;
	}
	public void settG6(int tG6) {
		this.tG6 = tG6;
	}
	public int gettG7() {
		return tG7;
	}
	public void settG7(int tG7) {
		this.tG7 = tG7;
	}
	public int gettG8() {
		return tG8;
	}
	public void settG8(int tG8) {
		this.tG8 = tG8;
	}
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
