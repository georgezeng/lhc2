package net.geozen.lhc2.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.geozen.lhc2.enums.SX;
import net.geozen.lhc2.nums.SxNums;
import net.geozen.lhc2.utils.luna.LunarCalendar;

public class SxUtil {

	public static SX getSxByYear(Date date) {
		Integer start = 1900;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		SX[] years = SX.seq();
		return years[(new LunarCalendar(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), false, false).getYear() - start)
				% years.length];
	}

	public static List<Integer> getSxNums(SX bmnSX, SX sx) {
		int delta = sx.getPos() - bmnSX.getPos();
		if (delta < 0) {
			delta = 0 - delta;
		}
		return SxNums.LISTS.get(delta);
	}

}
