package com.order.sample;

import lombok.val;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author devagoud
 */
@Configuration
@EntityScan(basePackages = "com.order.sample")
@ComponentScan(basePackages = {"com.order.sample","com.order.sample.controller","com.order.sample.domain"})
@EnableReactiveMongoRepositories("com.order.sample.domain.infrastructor")
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        val cros = registry.addMapping("/**");
        cros.allowedMethods("GET", "POST", "PUT","DELETE","OPTIONS");
        cros.allowedHeaders("*");
    }

}
