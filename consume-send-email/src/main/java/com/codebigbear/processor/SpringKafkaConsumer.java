package com.codebigbear.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SpringKafkaConsumer {

    public static void main(String[] args) {

        SpringApplication.run(SpringKafkaConsumer.class, args);
    }
}
