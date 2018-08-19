package com.mbfw.entity.basic;

/**
 * 后台返回数据code，msg取值范围
 */
public class ResultCodeConst {
    // 成功处理请求
    public static final int RESULT_CODE_SUCCESS = 200;
    public static final String RESULT_MSG_SUCCESS = "success";
    // bad request
    public static final int RESULT_CODE_BAD_REQUEST = 412;
    public static final String RESULT_MSG_BAD_REQUEST = "bad request";
    // 没有对应结果
    public static final int RESULT_CODE_SERVER_ERROR = 500;
    public static final String RESULT_MSG_SERVER_ERROR = "no result";

}
