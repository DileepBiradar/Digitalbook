package com.author.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.author.controller.BookController;
import com.author.entity.Book;
import com.author.entity.BookSearchRequest;
import com.author.service.BookServiceImpl;
import com.google.common.net.MediaType;

@WebMvcTest(BookController.class)
class BookcontrollerTest {
	@Autowired
	private BookController bookcontroller;
	
	@MockBean
	private BookServiceImpl bookService;

	private Book book;
	
	@BeforeEach
	
	void setUp() {	
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
	 void saveBook() throws Exception {
		  
		Book bookInput=new Book();
		bookInput.setBookId(1);
		bookInput.setTitle("");
		bookInput.setCategory("");
		bookInput.setImage("");
		bookInput.setPrice(1);
		bookInput.setPublisher("");
		bookInput.setCategory("");
		bookInput.setActive("");
		bookInput.setAuthorName("");
		bookInput.setAuthorEmail("");
		bookInput.setContent("");
		bookInput.setPaymentId("");
		
	Mockito.when(bookService.saveBook(bookInput)).thenReturn(book);

	
		 }
	 
	 @Test
		 void saveBookSearchRequest() throws Exception {
	 BookSearchRequest bookSearchRequestInput = new BookSearchRequest();
	 bookSearchRequestInput.setCategory("");
	 bookSearchRequestInput.setAuthorName("");
	 bookSearchRequestInput.setPrice(20);
	 bookSearchRequestInput.setPublisher("");
	
 }
	 
}
	 
	 
	 
	
