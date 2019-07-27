package net.geozen.lhc2.dto;

public class QueryInfo<T> {
	private T data;
	private PageInfo page;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public PageInfo getPage() {
		return page;
	}

	public void setPage(PageInfo page) {
		this.page = page;
	}
}
