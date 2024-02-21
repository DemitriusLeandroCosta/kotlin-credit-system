package com.aideia.creditapplicationsystem.configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
 class Swagger {
    @Bean
    fun publicApi(): GroupedOpenApi? {
          return GroupedOpenApi.builder()
            .group("creditapplicationsystem")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()
        }
}