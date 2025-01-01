package com.aurora.emby.common.dto;

import lombok.Data;

import java.util.Collection;

import static com.aurora.emby.common.dto.ApiCode.SUCCESS;


/**
 * @description: Response with batch record to return,
 * usually use in conditional query
 */
@Data
public class MultiResponse<T> extends Response {
    private static final long serialVersionUID = 1L;

    private Collection<T> data;

    public static MultiResponse buildSuccess() {
        return (MultiResponse) new MultiResponse()
                .setCode(SUCCESS.getCode())
                .setMessage(SUCCESS.getMessage());
    }

    public static MultiResponse buildFailure(ApiCode apiCode) {
        return (MultiResponse) new MultiResponse()
                .setCode(apiCode.getCode())
                .setMessage(apiCode.getMessage());
    }

    public static <T> MultiResponse<T> of(Collection<T> data) {
        MultiResponse multiResponse = (MultiResponse) new MultiResponse()
                .setCode(SUCCESS.getCode())
                .setMessage(SUCCESS.getMessage());
        multiResponse.setData(data);
        return multiResponse;
    }

}
