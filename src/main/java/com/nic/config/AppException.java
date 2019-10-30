package com.nic.config;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;

    public AppException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public AppException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public AppException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.code = errorCode.getCode();
    }

    public AppException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode.getMessage() + ": " + message, cause);
        this.code = errorCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
