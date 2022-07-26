package com.kt.springdemodatajpa.util;


import com.kt.springdemodatajpa.model.CommonResponse;
import com.kt.springdemodatajpa.model.ListResponse;
import com.kt.springdemodatajpa.model.SingleResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResponseUtil {
    public static <T> ListResponse<T> getSuccessListResponse(List<T> value) {
        var response = new ListResponse<T>();

        response.setCode(200);
        response.setMsg("Success");
        response.setSuccess(true);
        response.setData(value);

        return response;
    }

    public static <T> SingleResponse<T> getSuccessSingleResponse(T value) {
        var response = new SingleResponse<T>();

        response.setCode(200);
        response.setMsg("Success");
        response.setSuccess(true);
        response.setData(value);

        return response;
    }

    public static CommonResponse getSuccessCommonResponse() {

        var response = new CommonResponse();
        response.setSuccess(true);
        response.setCode(200);
        response.setMsg("Success");

        return response;
    }

}
