package net.geozen.lhc2.dto;

import lombok.Data;

@Data
public class QueryInfo<T> {
	private T data;
	private PageInfo page;
}
