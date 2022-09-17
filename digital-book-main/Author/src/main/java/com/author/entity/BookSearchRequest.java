package com.author.entity;

public class BookSearchRequest {

	private String category;
	private String authorName;
	private int price;
	private String publisher;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "BookSearchRequest [category=" + category + ", authorName=" + authorName + ", price=" + price
				+ ", publisher=" + publisher + "]";
	}

	
	
}
