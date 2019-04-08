package net.geozen.lhc3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "lhc3_color_yz_2")
@Data
public class Lhc3ColorYz2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phase;
	private String tables;
	private String type;
	private String wrColor;
	private String yzrColor;
	private String yzgColor;
	private int wr;
	private int wrBase;
	private int wrPos;
	private int yzr;
	private int yzrBase;
	private int yzrPos;
	private int yzg;
	private int yzgBase;
	private int yzgPos;
}
