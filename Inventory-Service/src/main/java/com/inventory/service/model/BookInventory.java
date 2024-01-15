package com.inventory.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "book_inventory")
public class BookInventory {
	@Id
	private String id;
	private String bookId; // ID reference to the book
	private int quantity; // Quantity of books in stock

}
