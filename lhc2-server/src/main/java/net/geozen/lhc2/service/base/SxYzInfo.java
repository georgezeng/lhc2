package net.geozen.lhc2.service.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.geozen.lhc2.enums.SX;

@AllArgsConstructor
@Data
public class SxYzInfo {
	private SX sx;
	private int yz;
}
