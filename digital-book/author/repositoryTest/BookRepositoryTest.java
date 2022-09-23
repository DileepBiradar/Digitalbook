package com.author.repositoryTest;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.author.entity.Book;
import com.author.entity.BookSearchRequest;
import com.author.service.IBookRepository;

@SpringBootTest
class BookRepositoryTest {
	
	@Autowired
	private IBookRepository bookrepository;
	
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
public void shouldSaveBook () {
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
	
	Book savedBook=bookrepository.save(book);
	
	
}	
	
	
}
