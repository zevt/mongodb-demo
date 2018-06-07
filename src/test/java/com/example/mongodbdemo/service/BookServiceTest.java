package com.example.mongodbdemo.service;

import com.example.mongodbdemo.model.Author;
import com.example.mongodbdemo.model.Book;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Viet Quoc Tran vt on 6/5/18. www.zeroexception.com
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = {"classpath:application-test.properties"})
public class BookServiceTest {


  @Autowired
  private BookService bookService;

  private String  authorName = "Mark Twain";

  @Before
  public void setUp() {

     Author author = new Author()
        .setName(authorName)
        .setAge(144);

    Book book = new Book()
        .setTitle("Book 1")
        .setAuthor(author);

    this.bookService.save(book);

    book = new Book()
        .setTitle("Book 2")
        .setAuthor(author);

    this.bookService.save(book);
  }



  @Test
  public void findByAuthorName() {
    List<Book> bookList = this.bookService.findByAuthorName(authorName);
    Assert.assertEquals(2, bookList.size());
  }

  @After
  public void tearDown() {
//    this.bookService.deleteAll();
  }
 }