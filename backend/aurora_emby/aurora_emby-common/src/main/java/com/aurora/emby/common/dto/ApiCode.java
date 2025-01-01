package com.aurora.emby.common.dto;

public enum ApiCode {
    SUCCESS(200, "success"),
    FAILED(1, "failed"),
    WRONG_PARM(400, "failed"),


    /*异常 1xxxx1-1xx100*/
    EXCEPTION_ERROR(100001, "服务器出现异常"),
    EXCEPTION_TIME_OUT(100002, "服务器处理消息超时了"),
    NO_PERMISSION(100003, "无权限访问"),
    TIME_OUT(100004, "访问超时"),
    NO_IDENTITY_VERIFICATION(100005, "身份校验不通过"),
    PERMISSION_OPERATION_NOT_LEGAL(100006, "权限操作不合法!"),



    /*基本错误 1xx100*/
    WRONG_PASS(100101, "密码错误"),
    WRONG_TOKEN(100102, "wrong token"),
    ACCOUNT_DISABLED(100103, "账号已禁用"),
    ACCOUNT_DEACTIVATED(100104, "账号已停用"),
    BLANK(100103, "parameter cannot be null"),
    COURSE_NOT_EXIST(100104, "Course does not exist"),
    APPLICATION_NOT_EXIST(100105, "application does not exist"),
    TOKEN_TIME_OUT(100106, "token过期,请重新登陆"),




    SYSTEM_UNKNOWN_ERROR(-1, "系统繁忙，请稍后再试....");


    private Integer code;
    private String message;

    ApiCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiCode{" + "code='" + code + '\'' + ", message='" + message + '\'' + '}';
    }

}
