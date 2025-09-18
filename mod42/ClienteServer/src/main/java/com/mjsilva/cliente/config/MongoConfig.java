package com.mjsilva.cliente.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.mjsilva.cliente.repository")
public class MongoConfig {

}
