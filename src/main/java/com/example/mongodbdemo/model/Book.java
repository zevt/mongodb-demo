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
@TypeAlias("Book")
public class Book {

  @Id
  @Getter
  private BigInteger id;
  @Getter
  private String title;
  @Getter
  private Author author;

  public Book setId(BigInteger id) {
    this.id = id;
    return this;
  }

  public Book setTitle(String title) {
    this.title = title;
    return this;
  }

  public Book setAuthor(Author author) {
    this.author = author;
    return this;
  }
}
