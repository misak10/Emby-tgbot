package com.aurora.emby.common.dto;

import lombok.Data;

import static com.aurora.emby.common.dto.ApiCode.SUCCESS;


@Data
public class SingleResponse<T> extends Response {

    private T data;

    public static SingleResponse buildSuccess() {
        return (SingleResponse) new SingleResponse()
                .setCode(SUCCESS.getCode())
                .setMessage(SUCCESS.getMessage());
    }

    public static SingleResponse buildFailure(ApiCode apiCode) {
        return (SingleResponse) new SingleResponse()
                .setCode(apiCode.getCode())
                .setMessage(apiCode.getMessage());
    }

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse singleResponse = (SingleResponse) new SingleResponse()
                .setCode(SUCCESS.getCode())
                .setMessage(SUCCESS.getMessage());
        singleResponse.setData(data);
        return singleResponse;
    }

}
