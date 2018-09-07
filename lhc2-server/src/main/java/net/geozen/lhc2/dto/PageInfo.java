package net.geozen.lhc2.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import lombok.Data;

@Data
public class PageInfo {
	private int num;
	private int size;
	private String property;
	private Direction order;

	public Pageable pageable() {
		if (property == null) {
			return PageRequest.of(num - 1, size);
		}
		return pageable(order, property);
	}

	public Pageable pageable(Direction direction, String... properties) {
		return PageRequest.of(num - 1, size, direction, properties);
	}
}