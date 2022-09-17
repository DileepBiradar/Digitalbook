package com.author.service;

import java.util.List;
import java.util.Optional;

import com.author.entity.Book;
import com.author.payload.ResponsePayload;

public interface IBookService {

	Book saveBook(Book book);

	Optional<Book> getBookById(int id);

	List<Book> showAllBook(String authorName);

	List<Book> showAllBookEmailBookId(String emailId, int bookId);

	List<Book> showBookOfEmailPaymentId(String emailId, String paymentId);

	List<Book> searchBook(String category, String author, int price, String publisher);

	List<Book> searchBooks();

	ResponsePayload deleteBook(int bookId);

	ResponsePayload updateBook(Book book);
}
