package net.geozen.lhc2.domain.sx;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.geozen.lhc2.domain.base.SxBaseEntity;

@Entity
@Table(name = "sxyz")
public class Sxyz extends SxBaseEntity {
	private int shu;
	private int niu;
	private int hu;
	private int tu;
	private int lonng;
	private int she;
	private int ma;
	private int yang;
	private int hou;
	private int ji;
	private int gou;
	private int zhu;

	public int getShu() {
		return shu;
	}

	public void setShu(int shu) {
		this.shu = shu;
	}

	public int getNiu() {
		return niu;
	}

	public void setNiu(int niu) {
		this.niu = niu;
	}

	public int getHu() {
		return hu;
	}

	public void setHu(int hu) {
		this.hu = hu;
	}

	public int getTu() {
		return tu;
	}

	public void setTu(int tu) {
		this.tu = tu;
	}

	public int getLonng() {
		return lonng;
	}

	public void setLonng(int lonng) {
		this.lonng = lonng;
	}

	public int getShe() {
		return she;
	}

	public void setShe(int she) {
		this.she = she;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public int getYang() {
		return yang;
	}

	public void setYang(int yang) {
		this.yang = yang;
	}

	public int getHou() {
		return hou;
	}

	public void setHou(int hou) {
		this.hou = hou;
	}

	public int getJi() {
		return ji;
	}

	public void setJi(int ji) {
		this.ji = ji;
	}

	public int getGou() {
		return gou;
	}

	public void setGou(int gou) {
		this.gou = gou;
	}

	public int getZhu() {
		return zhu;
	}

	public void setZhu(int zhu) {
		this.zhu = zhu;
	}
}
