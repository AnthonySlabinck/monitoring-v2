package com.example.monitoringservice.rabbit;

import com.rabbitmq.http.client.ReactorNettyClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RabbitProperties.class)
public class RabbitConfiguration {

    @Bean
    public ReactorNettyClient reactorNettyClient(RabbitProperties properties) {
        return new ReactorNettyClient(properties.getUrl(), properties.getUsername(), properties.getPassword());
    }
}
