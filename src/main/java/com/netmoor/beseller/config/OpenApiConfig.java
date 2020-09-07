package com.netmoor.beseller.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApiConfig.
 *
 * @author Nikolay_Batov
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "NetMoor Seller", version = "v0.0"))
@SecurityScheme(
        name = "JSESSIONID",
        in = SecuritySchemeIn.COOKIE,
        type = SecuritySchemeType.APIKEY
)
public class OpenApiConfig {
}
