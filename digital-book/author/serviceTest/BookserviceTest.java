package com.author.serviceTest;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.author.entity.Book;
import com.author.entity.BookSearchRequest;
import com.author.service.BookServiceImpl;
import com.author.service.IBookRepository;

@SpringBootTest
class BookserviceTest {
	
	@Autowired
	private BookServiceImpl bookservice;
	
	@MockBean
	private IBookRepository bookRepository;
	
	@BeforeEach
	 void setUp() throws Exception {
		
		Book book = new Book();
		
		
		book.setBookId(1);
		book.setTitle("");
		book.setCategory("");
		book.setImage("");
		book.setPrice(1);
		book.setPublisher("");
		book.setActive("");
		book.setAuthorName("");
		book.setAuthorEmail("");
		
		book.setContent("");
		book.setPaymentId("");
		
		Mockito.when(bookRepository.findById(1)).thenReturn(Optional.ofNullable(book));
	}
	
	BookSearchRequest getBookSearchRequest() {
		BookSearchRequest bookSearchRequest = new BookSearchRequest();
		bookSearchRequest.setCategory("");
		bookSearchRequest.setAuthorName("");
		bookSearchRequest.setPrice(20);
		bookSearchRequest.setPublisher("");
		
		return bookSearchRequest;
		
		
	}
@Test
@DisplayName("Find book by ID")

public void shouldFindBookById() {
	int bookId =1;
	Optional<Book> bookFound = bookservice.getBookById(bookId);
   
	
}
}
