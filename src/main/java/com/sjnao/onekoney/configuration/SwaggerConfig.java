package com.sjnao.onekoney.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
        @Primary
        @Bean
        public SwaggerResourcesProvider swaggerResourcesProvider(
                        InMemorySwaggerResourcesProvider defaultResourcesProvider) {
                return () -> {
                        List<SwaggerResource> resources = new ArrayList<>();
                        Arrays.asList("v1").forEach(resourceName -> resources.add(loadResource(resourceName)));
                        return resources;
                };
        }

        private SwaggerResource loadResource(String resource) {
                SwaggerResource wsResource = new SwaggerResource();
                wsResource.setName(resource);
                wsResource.setSwaggerVersion("3.0");
                wsResource.setLocation("/swagger-apis/" + resource + "/openapi.yaml");
                return wsResource;
        }
}