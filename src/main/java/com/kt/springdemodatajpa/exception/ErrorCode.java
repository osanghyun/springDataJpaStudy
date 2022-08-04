package com.kt.springdemodatajpa.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    INVALID_PARAMETER(400, null, "Invalid Request Data"),
    DUPLICATED_USER(400, "U001", "Duplicated User Data"),
    USER_NOT_FOUND(404, "U002", "User Not Found");

    private final int status;
    private final String code;
    private final String message;
}
