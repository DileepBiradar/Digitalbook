package com.author.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.entity.Book;
import com.author.entity.BookSearchRequest;
import com.author.exceptionHandling.ResourceNotFoundException;
import com.author.payload.ResponsePayload;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	IBookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Optional<Book> getBookById(int id) {
		return bookRepository.findById(id);
	}

	@Override
	public List<Book> showAllBook(String email) {
		return bookRepository.showBookOfAuthor(email);
	}

	@Override
	public List<Book> showAllBookEmailBookId(String email, int bookId) {
		return bookRepository.showBookOfEmailBookId(email, bookId);
	}

	@Override
	public List<Book> showBookOfEmailPaymentId(String email, String paymentId) {
		return bookRepository.showBookOfEmailPaymenId(email, paymentId);
	}

	@Override
	public List<Book> searchBook(String category, String author, int price, String publisher) {
		List<Book> obj = bookRepository.searchBook(category, author, price, publisher);
		return obj.stream().filter(book -> book.getActive().equals("y")).collect(Collectors.toList());
	}

	@Override
	public List<Book> searchBooks() {
		List<Book> obj = bookRepository.searchBooks();
		return obj.stream().filter(book -> book.getActive().equals("y")).collect(Collectors.toList());
	}

	@Override
	public ResponsePayload deleteBook(int bookId) {
		try {
			Book findBook = bookRepository.findById(bookId).get();
			bookRepository.delete(findBook);
			return new ResponsePayload(201, "Deleted successfully");
		} catch (Exception ex) {
			return new ResponsePayload(415, "Error");
		}

	}

	@Override
	public ResponsePayload updateBook(Book book) {
		try {
			Book obj = bookRepository.findById(book.getBookId())
					.orElseThrow(() -> new ResourceNotFoundException("Book", "id", book.getBookId()));
			if (book.getImage() != null) {
				obj.setImage(book.getImage());
			}
			if (book.getTitle() != null) {
				obj.setTitle(book.getTitle());
			}
			if (book.getCategory() != null) {
				obj.setCategory(book.getCategory());
			}
			if (book.getActive() != null) {
				obj.setActive(book.getActive());
			}
			if (book.getContent() != null) {
				obj.setContent(book.getContent());
			}
			if (book.getPrice() >= 0) {
				obj.setPrice(book.getPrice());
			}
			if (book.getPublishDate() != null) {
				obj.setPublishDate(book.getPublishDate());
			}
			bookRepository.save(obj);
			return new ResponsePayload(201, "Successfully Uodated", obj);
		} catch (Exception ex) {
			return new ResponsePayload(415, "Something went wrong");
		}
	}

}
