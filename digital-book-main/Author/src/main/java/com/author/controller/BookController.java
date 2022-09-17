package com.author.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.author.entity.Book;
import com.author.entity.BookSearchRequest;
import com.author.exceptionHandling.ResourceNotFoundException;
import com.author.service.BookServiceImpl;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	BookServiceImpl bookService;

	@PostMapping("/saveBook")
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@GetMapping("/getBookById/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		System.out.println("Book" + id);
		Book obj = bookService.getBookById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
		return new ResponseEntity<Book>(obj, HttpStatus.OK);
	}

	@GetMapping("/showAllBook/{email}")
	public List<Book> showAllBook(@PathVariable("email") String email) {
		return bookService.showAllBook(email);
	}

	@GetMapping("/showAllBook/{email}/book/{bookId}")
	public List<Book> showAllBook_email_bookId(@PathVariable("email") String email,
			@PathVariable("bookId") int bookId) {
		return bookService.showAllBookEmailBookId(email, bookId);
	}

	@GetMapping("/showAllBook/{email}/books/{paymentId}")
	public List<Book> showAllBook_emaild_paymentId(@PathVariable("email") String email,
			@PathVariable("paymentId") String paymentId) {
		return bookService.showBookOfEmailPaymentId(email, paymentId);
	}

	@PostMapping("/searchBook")
	public List<Book> searchBook(@RequestBody BookSearchRequest bookSearch) {
		return bookService.searchBook(bookSearch.getCategory(), bookSearch.getAuthorName(), bookSearch.getPrice(),
				bookSearch.getPublisher());

	}
	
	@GetMapping("/searchBooks")
	public List<Book> searchBooks() {
		return bookService.searchBooks();

	}


	@DeleteMapping("/deleteBook/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable("bookId") int bookId) {
		return ResponseEntity.ok(bookService.deleteBook(bookId));
	}

	@PatchMapping("/updateBook")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.updateBook(book));
	}

}
