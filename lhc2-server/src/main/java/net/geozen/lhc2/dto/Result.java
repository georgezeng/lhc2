package net.geozen.lhc2.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.geozen.lhc2.utils.CommonUtil;

/**
 * Created by DOmmy on 2017/12/18.
 */
@Data
@AllArgsConstructor
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

}
