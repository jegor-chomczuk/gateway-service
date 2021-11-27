package com.homebudgetmanager.gatewayservice.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.path("/category/**")
                        .uri("lb://user-service"))
                .route(p -> p.path("/user/**")
                        .uri("lb://user-service"))
                .route(p -> p.path("/expense/**")
                        .uri("lb://expenses-service"))
                .route(p -> p.path("/income/**")
                        .uri("lb://income-service"))
                .route(p -> p.path("/planned-expense/**")
                        .uri("lb://planned-expenses-service"))
                .route(p -> p.path("/planned-income/**")
                        .uri("lb://planned-income-service"))
                .build();
    }
}
