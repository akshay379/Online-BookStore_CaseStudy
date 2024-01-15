package com.inventory.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.service.model.BookInventory;

@Repository
public interface BookInventoryRepository extends MongoRepository<BookInventory, String> {
	BookInventory findByBookId(String bookId);

	void deleteByBookId(String bookId);
}
