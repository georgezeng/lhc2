package net.geozen.lhc2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "times_yz")
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

	public int getTime0() {
		return time0;
	}

	public void setTime0(int time0) {
		this.time0 = time0;
	}

	public int getTime12() {
		return time12;
	}

	public void setTime12(int time12) {
		this.time12 = time12;
	}

	public int getTime3Plus() {
		return time3Plus;
	}

	public void setTime3Plus(int time3Plus) {
		this.time3Plus = time3Plus;
	}

	public int getZf0() {
		return zf0;
	}

	public void setZf0(int zf0) {
		this.zf0 = zf0;
	}

	public int getZf1() {
		return zf1;
	}

	public void setZf1(int zf1) {
		this.zf1 = zf1;
	}

	public int getZf2() {
		return zf2;
	}

	public void setZf2(int zf2) {
		this.zf2 = zf2;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
}
