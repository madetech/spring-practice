package com.madetech.dvla.hgv.mot.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfiguration {
    @Value("${database.hostname}")
    private String hostname;

    public @Bean MongoClient mongoClient() {
        return MongoClients.create("mongodb://" + hostname + ":27017");
    }
}
