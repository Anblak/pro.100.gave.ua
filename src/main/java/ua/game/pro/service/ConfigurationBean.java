package ua.game.pro.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ua.game.pro.serviceImpl.KafkaServiceImpl;

import java.io.IOException;

@Configuration
public class ConfigurationBean {

    @Bean()
    @Scope("singleton")
    public KafkaService kafkaService() throws IOException {
        return new KafkaServiceImpl();
    }
}
