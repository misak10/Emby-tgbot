package com.aurora.emby.infrastructure.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {



    /**
     * 全局controller包路径
     */
    private static final String BASE_PACKAGE = "com.aurora.emby.interfaces.controller";


    @Bean
    public Docket buildDocket() {


        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //.host("127.0.0.1:8080") //设置ip和端口，或者域名
                .select()  //启动用于api选择的生成器
                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.aurora.emby.interfaces.controller"))//指定controller路径
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(globalRequestParameters())
                .useDefaultResponseMessages(false);
    }


    private List<RequestParameter> globalRequestParameters() {
        return Arrays.asList(new RequestParameterBuilder()
                .name("Authorization")
                .description("令牌")
                .in(ParameterType.HEADER)
                .required(true)
                .build());
    }

   /* @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.g0.education.web"))
                .paths(PathSelectors.any())
                .build()

                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

    }
    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeys;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(path -> {
                    String[] split = antMatchers.split(",");
                    for (String s : split) {

                        boolean flag =pathMatcher.match(path, s);
                        if (flag) return false;
                    }

                    // 过滤掉不需要token验证的接口
                    return true;
                })
                .build());
        return securityContexts;
    }
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }*/



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("极光管理系统")
                .description("极光管理系统")
                .version("1.0.2")
                .build();
    }


}
