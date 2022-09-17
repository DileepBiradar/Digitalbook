package com.reader.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.reader.entity.Book;
import com.reader.entity.BookSearchRequest;
import com.reader.exceptionHandling.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/digitalbooks")
@CrossOrigin(origins = "http://localhost:4200")
public class ReaderController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/book/emaildSearch")
	public List<Book> searchBookEmaild(@RequestBody BookSearchRequest bookSearchRequest) {
		List<Book> searchBook = this.restTemplate
				.getForObject("http://author-service/book/showAllBook/" + bookSearchRequest.getEmailId(), List.class);
		return searchBook;
	}

	@PostMapping("/book/emaildBookIdSearch")
	public List<Book> searchBookEmaildBookId(@RequestBody BookSearchRequest bookSearchRequest) {
		List<Book> searchBook = this.restTemplate.getForObject("http://author-service/book/showAllBook/"
				+ bookSearchRequest.getEmailId() + "/book/" + bookSearchRequest.getBookId(), List.class);
		return searchBook;
	}

	@PostMapping("/book/emaildPaymentSearch")
	public List<Book> searchBookEmaildPaymentId(@RequestBody BookSearchRequest bookSearchRequest) {
		List<Book> searchBook = this.restTemplate.getForObject("http://author-service/book/showAllBook/"
				+ bookSearchRequest.getEmailId() + "/book/" + bookSearchRequest.getPaymentId(), List.class);
		return searchBook;
	}

	@GetMapping("/searchAllBooks")
	public List<Book> searchAllBook() {
		List<Book> showAllBook = this.restTemplate.getForObject("http://author-service/book/searchBooks", List.class);
		return showAllBook;
	}

	@GetMapping("/searchBookById/{id}")
	public Object searchBookById(@PathVariable("id") int id) {
		try {
			Book getBookById = this.restTemplate.getForObject("http://author-service/book/getBookById/" + id,
					Book.class);
			return getBookById;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			throw new ResourceNotFoundException("Book", "id", id);
		}
	}
}
