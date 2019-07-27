package net.geozen.lhc2.dto;

import java.util.List;

public class PickNumPayload {
	private String phase;
	private List<PickNumCountInfo> infos;

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public List<PickNumCountInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<PickNumCountInfo> infos) {
		this.infos = infos;
	}
}