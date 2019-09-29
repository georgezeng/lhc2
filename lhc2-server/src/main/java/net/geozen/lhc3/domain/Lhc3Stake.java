package net.geozen.lhc3.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lhc3_stake")
public class Lhc3Stake {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phase;
	private int num;
	private String type;
	private BigDecimal currentAmount = BigDecimal.ZERO;
	private BigDecimal lastBonus = BigDecimal.ZERO;
	private BigDecimal historyAmount = BigDecimal.ZERO;
	private BigDecimal historyBonus = BigDecimal.ZERO;
	private int time1;
	private int time2;
	private int time3;
	private int time4;
	private int time5;
	private int time6;
	private int time7;
	private int time8;
	private int time9;
	private int time10;
	private int time11;
	private int time12;
	private int time13;
	private int time14;
	private int time15;
	private int time16;
	private int time17;
	private int time18;
	private int time19;
	private int time20;
	private int time21;
	private int time22;
	private int time23;
	private int time24;
	private int time25;
	private int time26;
	private int time27;
	private int time28;
	private int time29;
	private int time30;
	private int time31;
	private int time32;
	private int time33;
	private int time34;
	private int time35;
	private int time36;
	private int time37;
	private int time38;
	private int time39;
	private int time40;
	private int time41;
	private int time42;
	private int time43;
	private int time44;
	private int time45;
	private int time46;
	private int time47;
	private int time48;
	private int time49;

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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	public BigDecimal getLastBonus() {
		return lastBonus;
	}

	public void setLastBonus(BigDecimal lastBonus) {
		this.lastBonus = lastBonus;
	}

	public BigDecimal getHistoryAmount() {
		return historyAmount;
	}

	public void setHistoryAmount(BigDecimal historyAmount) {
		this.historyAmount = historyAmount;
	}

	public BigDecimal getHistoryBonus() {
		return historyBonus;
	}

	public void setHistoryBonus(BigDecimal historyBonus) {
		this.historyBonus = historyBonus;
	}

	public int getTime1() {
		return time1;
	}

	public void setTime1(int time1) {
		this.time1 = time1;
	}

	public int getTime2() {
		return time2;
	}

	public void setTime2(int time2) {
		this.time2 = time2;
	}

	public int getTime3() {
		return time3;
	}

	public void setTime3(int time3) {
		this.time3 = time3;
	}

	public int getTime4() {
		return time4;
	}

	public void setTime4(int time4) {
		this.time4 = time4;
	}

	public int getTime5() {
		return time5;
	}

	public void setTime5(int time5) {
		this.time5 = time5;
	}

	public int getTime6() {
		return time6;
	}

	public void setTime6(int time6) {
		this.time6 = time6;
	}

	public int getTime7() {
		return time7;
	}

	public void setTime7(int time7) {
		this.time7 = time7;
	}

	public int getTime8() {
		return time8;
	}

	public void setTime8(int time8) {
		this.time8 = time8;
	}

	public int getTime9() {
		return time9;
	}

	public void setTime9(int time9) {
		this.time9 = time9;
	}

	public int getTime10() {
		return time10;
	}

	public void setTime10(int time10) {
		this.time10 = time10;
	}

	public int getTime11() {
		return time11;
	}

	public void setTime11(int time11) {
		this.time11 = time11;
	}

	public int getTime12() {
		return time12;
	}

	public void setTime12(int time12) {
		this.time12 = time12;
	}

	public int getTime13() {
		return time13;
	}

	public void setTime13(int time13) {
		this.time13 = time13;
	}

	public int getTime14() {
		return time14;
	}

	public void setTime14(int time14) {
		this.time14 = time14;
	}

	public int getTime15() {
		return time15;
	}

	public void setTime15(int time15) {
		this.time15 = time15;
	}

	public int getTime16() {
		return time16;
	}

	public void setTime16(int time16) {
		this.time16 = time16;
	}

	public int getTime17() {
		return time17;
	}

	public void setTime17(int time17) {
		this.time17 = time17;
	}

	public int getTime18() {
		return time18;
	}

	public void setTime18(int time18) {
		this.time18 = time18;
	}

	public int getTime19() {
		return time19;
	}

	public void setTime19(int time19) {
		this.time19 = time19;
	}

	public int getTime20() {
		return time20;
	}

	public void setTime20(int time20) {
		this.time20 = time20;
	}

	public int getTime21() {
		return time21;
	}

	public void setTime21(int time21) {
		this.time21 = time21;
	}

	public int getTime22() {
		return time22;
	}

	public void setTime22(int time22) {
		this.time22 = time22;
	}

	public int getTime23() {
		return time23;
	}

	public void setTime23(int time23) {
		this.time23 = time23;
	}

	public int getTime24() {
		return time24;
	}

	public void setTime24(int time24) {
		this.time24 = time24;
	}

	public int getTime25() {
		return time25;
	}

	public void setTime25(int time25) {
		this.time25 = time25;
	}

	public int getTime26() {
		return time26;
	}

	public void setTime26(int time26) {
		this.time26 = time26;
	}

	public int getTime27() {
		return time27;
	}

	public void setTime27(int time27) {
		this.time27 = time27;
	}

	public int getTime28() {
		return time28;
	}

	public void setTime28(int time28) {
		this.time28 = time28;
	}

	public int getTime29() {
		return time29;
	}

	public void setTime29(int time29) {
		this.time29 = time29;
	}

	public int getTime30() {
		return time30;
	}

	public void setTime30(int time30) {
		this.time30 = time30;
	}

	public int getTime31() {
		return time31;
	}

	public void setTime31(int time31) {
		this.time31 = time31;
	}

	public int getTime32() {
		return time32;
	}

	public void setTime32(int time32) {
		this.time32 = time32;
	}

	public int getTime33() {
		return time33;
	}

	public void setTime33(int time33) {
		this.time33 = time33;
	}

	public int getTime34() {
		return time34;
	}

	public void setTime34(int time34) {
		this.time34 = time34;
	}

	public int getTime35() {
		return time35;
	}

	public void setTime35(int time35) {
		this.time35 = time35;
	}

	public int getTime36() {
		return time36;
	}

	public void setTime36(int time36) {
		this.time36 = time36;
	}

	public int getTime37() {
		return time37;
	}

	public void setTime37(int time37) {
		this.time37 = time37;
	}

	public int getTime38() {
		return time38;
	}

	public void setTime38(int time38) {
		this.time38 = time38;
	}

	public int getTime39() {
		return time39;
	}

	public void setTime39(int time39) {
		this.time39 = time39;
	}

	public int getTime40() {
		return time40;
	}

	public void setTime40(int time40) {
		this.time40 = time40;
	}

	public int getTime41() {
		return time41;
	}

	public void setTime41(int time41) {
		this.time41 = time41;
	}

	public int getTime42() {
		return time42;
	}

	public void setTime42(int time42) {
		this.time42 = time42;
	}

	public int getTime43() {
		return time43;
	}

	public void setTime43(int time43) {
		this.time43 = time43;
	}

	public int getTime44() {
		return time44;
	}

	public void setTime44(int time44) {
		this.time44 = time44;
	}

	public int getTime45() {
		return time45;
	}

	public void setTime45(int time45) {
		this.time45 = time45;
	}

	public int getTime46() {
		return time46;
	}

	public void setTime46(int time46) {
		this.time46 = time46;
	}

	public int getTime47() {
		return time47;
	}

	public void setTime47(int time47) {
		this.time47 = time47;
	}

	public int getTime48() {
		return time48;
	}

	public void setTime48(int time48) {
		this.time48 = time48;
	}

	public int getTime49() {
		return time49;
	}

	public void setTime49(int time49) {
		this.time49 = time49;
	}
}
