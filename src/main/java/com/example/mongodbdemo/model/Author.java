package com.example.mongodbdemo.model;

import java.math.BigInteger;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Viet Quoc Tran vt on 6/5/18. www.zeroexception.com
 */

@Document
@TypeAlias("Author")
public class Author {

  @Id
  @Getter
  private BigInteger id;

  @Getter
  private String name;
  @Getter
  private int age;
// just to keep Spring data happy
  public Author() {
  }

  public Author setId(BigInteger id) {
    this.id = id;
    return this;
  }

  public Author setName(String name) {
    this.name = name;
    return this;
  }

  public Author setAge(int age) {
    this.age = age;
    return this;
  }
}
