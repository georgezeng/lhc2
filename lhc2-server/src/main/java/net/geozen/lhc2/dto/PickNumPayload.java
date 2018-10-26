package net.geozen.lhc2.dto;

import java.util.List;

import lombok.Data;

@Data
public class PickNumPayload {
	private int phase;
	private List<PickNumCountInfo> infos;
}