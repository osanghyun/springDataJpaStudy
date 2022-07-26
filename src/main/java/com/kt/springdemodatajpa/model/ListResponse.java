package com.kt.springdemodatajpa.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListResponse<T> extends CommonResponse {
    private List<T> data;
}
