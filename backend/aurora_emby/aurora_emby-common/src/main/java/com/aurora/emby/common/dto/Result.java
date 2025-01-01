package com.aurora.emby.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

import static com.aurora.emby.common.dto.ApiCode.SUCCESS;


@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Result<T> implements Serializable {


    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;


    public Result() {

    }


    public static Result<String> fail(Integer errorCode, String message) {
        return new Result<String>()
                .setCode(errorCode)
                .setMessage(message);
    }

    public static Result<String> success() {
        return new Result<String>()
                .setCode(SUCCESS.getCode())
                .setMessage(SUCCESS.getMessage());
    }

    public Result<T> success(Integer code, String message, T t) {
        return new Result<T>()
                .setCode(code)
                .setMessage(message)
                .setData(t);
    }

    public static Result<Object> success(String message, Object data) {
        return new Result<Object>()
                .setCode(SUCCESS.getCode())
                .setMessage(message)
                .setData(data);
    }

    public static Result<Object> success(Object data) {
        return new Result<Object>()
                .setCode(SUCCESS.getCode())
                .setMessage(SUCCESS.getMessage())
                .setData(data);
    }


    private Result<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public Result<T> failCode(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    public static Result failCode(ApiCode apiCode) {
        return new Result<>()
                .setCode(apiCode.getCode())
                .setMessage(apiCode.getMessage());
    }

}
