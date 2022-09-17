package com.author.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.author.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
	@Query(value = "select * from book", nativeQuery = true)
	List<Book> searchBooks();

	@Query(value = "select * from book where category like %?1% or author_name like %?2% or price<=?3 or publisher like %?4%", nativeQuery = true)
	List<Book> searchBook(String category, String author, int price, String publisher);

	@Query(value = "SELECT * FROM  book WHERE author_email like %?1%", nativeQuery = true)
	List<Book> showBookOfAuthor(String email);

	@Query(value = "SELECT * FROM  book WHERE author_email like %?1% and book_id like %?2%", nativeQuery = true)
	List<Book> showBookOfEmailBookId(String email, int bookId);

	@Query(value = "SELECT * FROM  book WHERE author_email like %?1% and paymentId like %?2%", nativeQuery = true)
	List<Book> showBookOfEmailPaymenId(String email, String paymentid);

}
