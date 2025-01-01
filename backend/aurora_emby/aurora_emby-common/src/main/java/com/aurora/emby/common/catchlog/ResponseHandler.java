package com.aurora.emby.common.catchlog;




import com.aurora.emby.common.dto.ApiCode;
import com.aurora.emby.common.dto.Response;
import com.aurora.emby.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class ResponseHandler {

    public static Object handle(Class returnType, String errCode, String errMsg){
        if (isColaResponse(returnType)){
            return handleColaResponse(returnType, errCode, errMsg);
        }
        return null;
    }

    public static Object handle(Class returnType, BaseException e){
        return handle(returnType, e.getErrCode(), e.getMessage());
    }


    private static Object handleColaResponse(Class returnType, String errCode, String errMsg) {
        try {
            Response response = (Response)returnType.newInstance();
            response.setCode(ApiCode.EXCEPTION_ERROR.getCode());
            response.setMessage(errMsg);
            return response;
        }
        catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return  null;
        }
    }


    private static boolean isColaResponse(Class returnType) {
        return  returnType == Response.class || returnType.getGenericSuperclass() == Response.class;
    }
}
