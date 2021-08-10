package com.xkf.system.bean;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xukefei
 * @create 2021-08-02 上午10:43
 */
public class ResultObject<T> {
    private int code;
    private String msg;
    private T data;

    public ResultObject() {
    }

    public ResultObject(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> ResultObject<T> success(String msg, T data) {
        return new ResultObject<T>(Code.SUCCESS.value, msg, data);
    }

    public static <T> ResultObject<T> notFound(String msg, T data) {
        return new ResultObject<T>(Code.NOT_FOUND.value, msg, data);
    }

    public static <T> ResultObject<T> error(String msg, T data) {
        return new ResultObject<T>(Code.ERROR.value, msg, data);
    }

    public enum Code {
        SUCCESS(HttpServletResponse.SC_OK),
        NOT_FOUND(HttpServletResponse.SC_NOT_FOUND),
        ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        private int value;

        Code(int value) {
            this.value = value;
        }
    }
}
