package com.ebbers.capslog.infrastructure.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Log API")
                        .license(new License()
                                .name("GNU General Public License v3.0")
                                .url("https://choosealicense.com/licenses/gpl-3.0/")));
    }
}
