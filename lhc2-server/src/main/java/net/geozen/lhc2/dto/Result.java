package net.geozen.lhc2.dto;

import java.io.Serializable;

import net.geozen.lhc2.utils.CommonUtil;

/**
 * Created by DOmmy on 2017/12/18.
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = -1;
	private boolean success;
	private String errorMsg;
	private T data;
	private String traceId;

	public static <T> Result<T> genSuccessResult(T data) {
		return new Result<T>(true, "", data, CommonUtil.getTraceId());
	}

	public static <T> Result<T> genFailResult(T data, String traceId, String errorMsg) {
		return new Result<T>(false, errorMsg, data, traceId);
	}

	public Result(boolean success, String errorMsg, T data, String traceId) {
		this.success = success;
		this.errorMsg = errorMsg;
		this.data = data;
		this.traceId = traceId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

}
