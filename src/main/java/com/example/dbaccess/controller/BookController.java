package com.example.dbaccess.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbaccess.datasource.mysql.domain.Book;
import com.example.dbaccess.datasource.mysql.domain.Author;
import com.example.dbaccess.datasource.mysql.repo.BookDetailRepo;
import com.example.dbaccess.datasource.mysql.repo.BookRepo;
import com.google.gson.Gson;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private BookDetailRepo bookDetailRepo;

	@RequestMapping(value = "/saveBook", method = org.springframework.web.bind.annotation.RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> saveBookInMySqlDB(@RequestBody String body) {
//		Gson gson = new Gson();
//		Book book = gson.fromJson(body, Book.class);
		Book book = new Book();
		book.setTitle("karuvachi kaviyam");
		book.setDescription("Tamil Gramathu kadhai");
		book.setPublishedDate(new Date());
		
		book.setAuthor(new Author("ShakesPeare", "Hamlet"));
		book = bookRepo.save(book);
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/saveBookDetail", method = org.springframework.web.bind.annotation.RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> saveBookDetailInMySqlDB(@RequestBody String body) {
		Gson gson = new Gson();
		Author bookDetail = gson.fromJson(body, Author.class);
		bookDetail = bookDetailRepo.save(bookDetail);
		return new ResponseEntity<>(bookDetail, HttpStatus.CREATED);
	}
}
