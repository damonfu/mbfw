package com.mbfw.entity.basic;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private static final long serialVersionUID = -2064461803556309703L;
    /***
     * 取值为{@link ResultCodeConst}
     */
    private int resultCode;//结果码
    private String resultMsg;//结果提示（错误时用）
    private boolean success;//后台是否成功
    private T data;//返回的业务数据

    public Response() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
