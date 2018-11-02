package com.example.demo.exception;

public class ValidateException extends RuntimeException {
    private Object params;

    public ValidateException(Object params, String message) {
        super(message);
        this.params = params;
    }

    public Object getParams() {
        return params;
    }
}
