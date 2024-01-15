package com.inventory.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.service.model.BookInventory;
import com.inventory.service.repository.BookInventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
    private BookInventoryRepository bookInventoryRepository;

    // Methods for managing book inventory

	 public BookInventory getBookInventoryByBookId(String bookId) {
	        return bookInventoryRepository.findByBookId(bookId);
	    }

	    public BookInventory updateBookInventory(BookInventory bookInventory) {
	        return bookInventoryRepository.save(bookInventory);
	    }

	    public void deleteBookInventoryByBookId(String bookId) {
	        bookInventoryRepository.deleteByBookId(bookId);
	    }

	    public void increaseBookStock(String bookId, int quantityToAdd) {
	        BookInventory bookInventory = bookInventoryRepository.findByBookId(bookId);
	        if (bookInventory != null) {
	            bookInventory.setQuantity(bookInventory.getQuantity() + quantityToAdd);
	            bookInventoryRepository.save(bookInventory);
	        }
	    }

	    public void decreaseBookStock(String bookId, int quantityToReduce) {
	        BookInventory bookInventory = bookInventoryRepository.findByBookId(bookId);
	        if (bookInventory != null) {
	            int updatedQuantity = bookInventory.getQuantity() - quantityToReduce;
	            if (updatedQuantity >= 0) {
	                bookInventory.setQuantity(updatedQuantity);
	                bookInventoryRepository.save(bookInventory);
	            }
	        }
	    }


}
