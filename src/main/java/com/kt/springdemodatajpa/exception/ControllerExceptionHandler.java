package com.kt.springdemodatajpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {

        ErrorCode errorCode = e.getErrorCode();

        ErrorResponse response
                = ErrorResponse.create()
                .status(errorCode.getStatus())
                .code(errorCode.getCode())
                .message(errorCode.getMessage());
        return new ResponseEntity<>(response, HttpStatus.resolve(errorCode.getStatus()));
    } // todo Httpstatus.resosolve(errorCode.getStatus) null 일 수 있는 문제.
}
