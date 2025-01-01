package com.aurora.emby.common.catchlog;


import com.aurora.emby.common.dto.ApiCode;
import com.aurora.emby.common.dto.Response;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;


@Configuration
@EnableAspectJAutoProxy
@RestControllerAdvice
public class CatchLogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(CatchLogAspect.class)
    public CatchLogAspect catchLogAspect() {
        return new CatchLogAspect();
    }


    @ExceptionHandler({WebExchangeBindException.class, MethodArgumentNotValidException.class, BindException.class})
    public Response handle(MethodArgumentNotValidException exception) {
        //获取参数校验错误集合
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        //格式化以提供友好的错误提示
        String data = String.format("参数校验错误（%s）：%s", fieldErrors.size(),
                fieldErrors.stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.joining(";")));
        return Response.buildFailure(ApiCode.WRONG_PARM, data);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public Response handleMethod(ConstraintViolationException exception) {
        String message = exception.getMessage();
        return Response.buildFailure(ApiCode.WRONG_PARM, message);
    }
}
