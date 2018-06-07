package com.example.mongodbdemo.configuration;

import com.example.mongodbdemo.model.Author;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:application-test.properties"})
public class MongoDBConfigurationTest {


  @Autowired
  private MongoTemplate mongoTemplate;

  private static final  String TEST_COLLCECTION = "TEST_COLELCTION_PERSON";

  @Test
  public void testMongoConfig() {
    Author person = new Author()
        .setName("John")
        .setAge(21);

    this.mongoTemplate.save(person,TEST_COLLCECTION);
    Query query = Query.query(Criteria.where("name").is("John")).limit(1);

    List<Author> personList = this.mongoTemplate.find(query, Author.class, TEST_COLLCECTION);
    Author p = personList.get(0);
    Assert.assertEquals(21, p.getAge());
  }
}