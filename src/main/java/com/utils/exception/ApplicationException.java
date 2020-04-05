package com.utils.exception;

public class ApplicationException extends RuntimeException {

    private Integer code;
    private Object data;

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(Integer code) {
        super(String.valueOf(code));
        this.code = code;
    }

    public ApplicationException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ApplicationException(Integer code, Object data) {
        super(data.toString());
        this.code = code;
        this.data = data;
    }

    public Integer getErrorCode() {
        return this.code;
    }

    public Object getData() {
        return this.data;
    }
}
