package com.kt.springdemodatajpa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_PARAMETER(400, null, "Invalid Request Data"),
    USER_NOT_FOUND(404, "U001", "User Not Found");

    private final int status;
    private final String code;
    private final String message;
}
