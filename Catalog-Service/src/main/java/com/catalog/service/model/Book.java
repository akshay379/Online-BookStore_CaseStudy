package com.catalog.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a book entity within the catalog service.
 * This class is annotated for MongoDB document mapping.
 */
@AllArgsConstructor
@ToString
@Getter
@Setter
@Document(collection = "books")
public class Book {
    
    /**
     * Unique identifier for the book.
     */
    @Id
    private String id;

    /**
     * Title of the book.
     */
    private String title;

    /**
     * Author of the book.
     */
    private String author;

    /**
     * ISBN (International Standard Book Number) of the book.
     */
    private String isbn;

    /**
     * Price of the book.
     */
    private double price;

    /**
     * Availability count of the book.
     */
    private int availability;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
    
    
}

