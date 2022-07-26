package com.kt.springdemodatajpa.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse {
    private boolean success;
    private int code;
    private String msg;
}
