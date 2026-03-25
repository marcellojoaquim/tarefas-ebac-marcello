package br.com.ebac.gateway_api.routing;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfiguration {

    @Bean
    RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("get-route",p ->
                        p.path("/get")
                                .filters(f -> f.addRequestHeader("OI", "EBAC"))
                                .uri("https://httpbin.org"))
                .route("ebac-host", p ->
                        p.host("*.ebac.com.br")
                                .filters(f -> f.addRequestHeader("Origin", "Site-EBAC"))
                                .uri("https://httpbin.org"))
                .build();
    }
}
