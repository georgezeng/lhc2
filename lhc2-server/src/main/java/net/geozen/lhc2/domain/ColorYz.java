package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "color_yz")
public class ColorYz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int phase;
	private String tables;
	private String type;
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
	private String lzColor;
	private String chColor;
	private int ch;
	private int lz;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
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

	public String getWrColor() {
		return wrColor;
	}

	public void setWrColor(String wrColor) {
		this.wrColor = wrColor;
	}

	public String getLzColor() {
		return lzColor;
	}

	public void setLzColor(String lzColor) {
		this.lzColor = lzColor;
	}

	public String getChColor() {
		return chColor;
	}

	public void setChColor(String chColor) {
		this.chColor = chColor;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getLz() {
		return lz;
	}

	public void setLz(int lz) {
		this.lz = lz;
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
}
