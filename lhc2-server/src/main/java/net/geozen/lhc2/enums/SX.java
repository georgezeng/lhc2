package net.geozen.lhc2.enums;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum SX {
	Shu(1, "鼠", 2, true, true, "Shu", 11), 
	Niu(2, "牛", 3, false, true, "Niu", 10), 
	Hu(3, "虎", 4, true, true, "Hu", 9), 
	Tu(4, "兔", 3, false, true, "Tu", 8), 
	Long(5, "龙", 4, true, true, "Lonng", 7), 
	She(6, "蛇", 5, false, true, "She", 6), 
	Ma(7, "马", 4, true, false, "Ma", 5), 
	Yang(8, "羊", 5, false, false, "Yang", 4), 
	Hou(9, "猴", 6, true, false, "Hou", 3), 
	Ji(10, "鸡", 5, false, false, "Ji", 2), 
	Gou(11, "狗", 6, true, false, "Gou", 1), 
	Zhu(12, "猪", 7, false, false, "Zhu", 0);

	private final int pos;

	private final String text;

	private final int sector;

	private final boolean single;

	private final boolean small;

	private final String column;
	
	private final int numsPos;

	public static List<SX> list() {
		List<SX> list = new ArrayList<>();
		list.add(Shu);
		list.add(Niu);
		list.add(Hu);
		list.add(Tu);
		list.add(Long);
		list.add(She);
		list.add(Ma);
		list.add(Yang);
		list.add(Hou);
		list.add(Ji);
		list.add(Gou);
		list.add(Zhu);
		return list;
	}
	
	private SX(int pos, String text, int sector, boolean single, boolean small, String column, int numsPos) {
		this.pos = pos;
		this.text = text;
		this.sector = sector;
		this.single = single;
		this.small = small;
		this.column = column;
		this.numsPos = numsPos;
	}

	public int getPos() {
		return pos;
	}

	public String getText() {
		return text;
	}

	public int getSector() {
		return sector;
	}

	public boolean isSingle() {
		return single;
	}

	public boolean isSmall() {
		return small;
	}

	public String getColumn() {
		return column;
	}

	public int getNumsPos() {
		return numsPos;
	}

	public static SX[] seq() {
		return new SX[] { Shu, Niu, Hu, Tu, Long, She, Ma, Yang, Hou, Ji, Gou, Zhu };
	}

	public static String[] names() {
		return new String[] { Shu.name(), Niu.name(), Hu.name(), Tu.name(), Long.name(), She.name(), Ma.name(), Yang.name(), Hou.name(), Ji.name(),
				Gou.name(), Zhu.name() };
	}

	public static SX textOf(String text) {
		for (SX sx : values()) {
			if (sx.text.equals(text)) {
				return sx;
			}
		}
		return null;
	}

	public static SX posOf(int pos) {
		for (SX sx : values()) {
			if (sx.pos == pos) {
				return sx;
			}
		}
		return null;
	}
	
	public String getName() {
		return name();
	}

	public boolean isShu() {
		return Shu.equals(this);
	}

	public boolean isNiu() {
		return Niu.equals(this);
	}

	public boolean isHu() {
		return Hu.equals(this);
	}

	public boolean isTu() {
		return Tu.equals(this);
	}

	public boolean isLong() {
		return Long.equals(this);
	}

	public boolean isShe() {
		return She.equals(this);
	}

	public boolean isMa() {
		return Ma.equals(this);
	}

	public boolean isYang() {
		return Yang.equals(this);
	}

	public boolean isHou() {
		return Hou.equals(this);
	}

	public boolean isJi() {
		return Ji.equals(this);
	}

	public boolean isGou() {
		return Gou.equals(this);
	}

	public boolean isZhu() {
		return Zhu.equals(this);
	}
}
