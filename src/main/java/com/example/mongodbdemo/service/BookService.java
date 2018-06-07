package com.example.mongodbdemo.service;

import com.example.mongodbdemo.model.Book;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author Viet Quoc Tran vt on 6/5/18. www.zeroexception.com
 */

@Service
public class BookService {

  private static final String BOOK_COLLECTION =  "BOOK_COLLECTION";

  @Autowired
  private MongoTemplate mongoTemplate;


  public void ensureIndex() {
    this.mongoTemplate.indexOps(BOOK_COLLECTION).ensureIndex(new Index().on("author.name", Direction.ASC));
    MongoCollection<Document> bookCollection = this.mongoTemplate.getCollection(BOOK_COLLECTION);
    bookCollection.createIndex(Indexes.ascending("author.name"));
    bookCollection.createIndex(Indexes.compoundIndex());

  }

  public void save(Book book) {
    this.mongoTemplate.save(book, BOOK_COLLECTION);

  }

  public List<Book> findByAuthorName(String authorName) {
    Query query = Query.query(Criteria.where("author.name").is(authorName));
    return this.mongoTemplate.find(query, Book.class, BOOK_COLLECTION);

  }

  public void deleteAll() {
    this.mongoTemplate.dropCollection(BOOK_COLLECTION);
  }
}
