package com.example.mongodbdemo;

import com.example.mongodbdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbDemoApplication implements CommandLineRunner  {

	@Autowired
	private BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.bookService.ensureIndex();
	}
}
