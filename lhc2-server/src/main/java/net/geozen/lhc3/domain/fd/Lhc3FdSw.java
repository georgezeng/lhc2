package net.geozen.lhc3.domain.fd;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.geozen.lhc3.domain.base.PosBaseEntity;

@Entity
@Table(name = "lhc3_fd_sw")
@Data
@EqualsAndHashCode(callSuper = true)
public class Lhc3FdSw extends PosBaseEntity {
	private String w1Arr;
	private String w2Arr;
	private String w3Arr;
	private String w4Arr;
	private String w5Arr;
	private String w6Arr;
	private String w7Arr;
	private String w8Arr;
	private String w9Arr;
	private String w10Arr;
	private String w11Arr;
	private String w12Arr;
}
