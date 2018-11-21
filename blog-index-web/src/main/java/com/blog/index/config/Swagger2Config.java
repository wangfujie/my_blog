package com.blog.index.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wangfujie
 * @date 2018-08-10 10:05
 * @description swagger配置
 *  参考：http://blog.csdn.net/catoop/article/details/50668896
 */
//@Configuration
//@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.blog.index"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("使用Swagger2构建RESTful API")
                .description("swagger的详细描述")
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("wangfj","http://127.0.0.1:8088","784727590@qq.com"))
                .version("1.0")
                .build();
    }

    /**
     * Swagger的常用注解
     *
     * @Api              修饰整个类，描述Controller的作用
     * @ApiOperation   描述一个类的一个方法，或者说一个接口
     * @ApiParam        单个参数描述
     * @ApiModel        用对象来接收参数
     * @ApiProperty     用对象接收参数时，描述对象的一个字段
     */
}