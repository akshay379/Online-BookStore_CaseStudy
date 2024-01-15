package com.inventory.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.service.model.BookInventory;
import com.inventory.service.serviceImpl.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;


    @GetMapping("/book/{bookId}")
    public BookInventory getBookInventory(@PathVariable String bookId) {
        return inventoryService.getBookInventoryByBookId(bookId);
    }

    @PutMapping("/book/update")
    public BookInventory updateBookInventory(@RequestBody BookInventory bookInventory) {
        return inventoryService.updateBookInventory(bookInventory);
    }

    @DeleteMapping("/book/{bookId}")
    public void deleteBookInventory(@PathVariable String bookId) {
        inventoryService.deleteBookInventoryByBookId(bookId);
    }

    @PostMapping("/book/{bookId}/increaseStock/{quantity}")
    public void increaseBookStock(@PathVariable String bookId, @PathVariable int quantity) {
        inventoryService.increaseBookStock(bookId, quantity);
    }

    @PostMapping("/book/{bookId}/decreaseStock/{quantity}")
    public void decreaseBookStock(@PathVariable String bookId, @PathVariable int quantity) {
        inventoryService.decreaseBookStock(bookId, quantity);
    }


}
