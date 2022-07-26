package com.kt.springdemodatajpa.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SingleResponse<T> extends CommonResponse {
    private T data;
}
