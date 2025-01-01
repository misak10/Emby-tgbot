package com.aurora.emby.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import static com.aurora.emby.common.dto.ApiCode.SUCCESS;



@Data
@Accessors(chain = true)
public class Response extends DTO {
    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;


    public static Response buildSuccess(String message) {
        return new Response()
                .setCode(SUCCESS.getCode())
                .setMessage(message);
    }


    public static Response buildSuccess() {
        return new Response()
                .setCode(SUCCESS.getCode())
                .setMessage(SUCCESS.getMessage());
    }


    public static Response buildFailure(ApiCode apiCode) {
        return new Response()
                .setCode(apiCode.getCode())
                .setMessage(apiCode.getMessage());
    }

    public static Response buildFailure(ApiCode apiCode, String message) {
        return new Response()
                .setCode(apiCode.getCode())
                .setMessage(message);
    }



    public static Response buildFailure(Integer code, String message) {
        return new Response()
                .setCode(code)
                .setMessage(message);
    }
}
