package com.example.mongodbdemo.configuration;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfiguration {

  @Value("${spring.data.mongodb.database}")
  private String database;
  @Value("${spring.data.mongodb.uri}")
  private String mongoUri;


  @Bean
  public MongoClient mongoClient() {
    MongoClientURI clientURI = new MongoClientURI(this.mongoUri);
    return new MongoClient(clientURI);
  }

  @Bean
  public MongoTemplate mongoTemplate() {
    MongoTemplate mongoTemplate = new MongoTemplate(this.mongoClient(), this.database);
    return mongoTemplate;
  }

}
