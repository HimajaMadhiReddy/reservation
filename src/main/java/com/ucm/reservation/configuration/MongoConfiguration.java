package com.ucm.reservation.configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;




@Configuration
@EnableMongoRepositories(basePackages = "com.ucm.reservation.repository")
public class MongoConfiguration  extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient( "127.0.0.1",27017);


    }
    @Override
    protected String getDatabaseName() {
        return "reservations";
    }


}


