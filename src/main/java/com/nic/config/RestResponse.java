package com.nic.config;

/**
 * 标准结果返回
 * Created by yongli.chen.
 */
public class RestResponse<T> {
    private Integer code;

    private String message;

    private T data;

    private String link;


    public RestResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public RestResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 返回成功构造器
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> success(T data) {
        return new RestResponse<T>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }

    /**
     * 失败构造器
     *
     * @param errorCode
     * @return
     */
    public static <T> RestResponse<T> fail(ErrorCode errorCode) {
        return new RestResponse<T>(errorCode.getCode(), errorCode.getMessage());
    }

    /**
     * 失败构造器
     *
     * @param errorCode
     * @param message
     * @return
     */
    public static <T> RestResponse<T> fail(ErrorCode errorCode, String message) {
        return new RestResponse<T>(errorCode.getCode(), message);
    }

    /**
     * 失败构造器
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> fail(ErrorCode errorCode, T data) {
        return new RestResponse<T>(errorCode.getCode(), errorCode.getMessage(), data);
    }
}
