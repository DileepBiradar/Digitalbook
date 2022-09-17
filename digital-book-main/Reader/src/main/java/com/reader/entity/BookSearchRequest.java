package com.reader.entity;

public class BookSearchRequest {

	private String category;
	private String authorName;
	private int price;
	private String publisher;
	private String emailId;
	private int bookId;
	private String paymentId;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public BookSearchRequest(String category, String authorName, String publisher, String emailId) {
		super();
		this.category = category;
		this.authorName = authorName;
		this.publisher = publisher;
		this.emailId = emailId;
	}

	public BookSearchRequest() {
		super();
	}

	public BookSearchRequest(String category, String authorName, int price, String publisher) {
		super();
		this.category = category;
		this.authorName = authorName;
		this.price = price;
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookSearchRequest [category=" + category + ", authorName=" + authorName + ", price=" + price
				+ ", publisher=" + publisher + "]";
	}

}
