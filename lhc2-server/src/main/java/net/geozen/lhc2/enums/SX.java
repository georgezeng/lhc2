package net.geozen.lhc2.enums;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = Shape.OBJECT)
public enum SX {
	Shu(1, "鼠", 2, true, true, "Shu"), 
	Niu(2, "牛", 3, false, true, "Niu"), 
	Hu(3, "虎", 4, true, true, "Hu"), 
	Tu(4, "兔", 3, false, true, "Tu"), 
	Long(5, "龙", 4, true, true, "Lonng"), 
	She(6, "蛇", 5, false, true, "She"), 
	Ma(7, "马", 4, true, false, "Ma"), 
	Yang(8, "羊", 5, false, false, "Yang"), 
	Hou(9, "猴", 6, true, false, "Hou"), 
	Ji(10, "鸡", 5, false, false, "Ji"), 
	Gou(11, "狗", 6, true, false, "Gou"), 
	Zhu(12, "猪", 7, false, false, "Zhu");

	private final int pos;

	private final String text;

	private final int sector;

	private final boolean single;

	private final boolean small;

	private final String column;

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
