package com.example.demo.api.controller;

import com.example.demo.api.ResponseResult;
import com.example.demo.api.ResponseResult.ResultCode;
import com.example.demo.exception.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseResult handle(Exception e) {
        logger.error("系统异常", e);
        return new ResponseResult<>(ResultCode.SERVICE_ERROR, "系统异常");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("校验异常");
        logger.error("request params --> {}", e.getBindingResult().getTarget().toString());
        return new ResponseResult<>(ResultCode.VALIDATE_ERROR, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseResult handleValidateException(ValidateException e) {
        logger.error("ValidateException");
        logger.error("params --> {}", e.getParams().toString());
        logger.error("error message --> {}", e.getMessage());
        return new ResponseResult<>(ResultCode.VALIDATE_ERROR, e.getMessage());
    }

}
