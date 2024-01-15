package com.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.user.service.model.BookInventory;

@RestController
@RequestMapping("/user/inventory")
public class InventoryClientController {

    private final String BASE_URL = "http://localhost:8084/inventory";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookInventory> getBookInventory(@PathVariable String bookId) {
        String url = BASE_URL + "/book/{bookId}";
        return restTemplate.getForEntity(url, BookInventory.class, bookId);
    }

    @PutMapping("/book/update")
    public ResponseEntity<BookInventory> updateBookInventory(@RequestBody BookInventory bookInventory) {
        String url = BASE_URL + "/book/update";
        return restTemplate.postForEntity(url, bookInventory, BookInventory.class);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBookInventory(@PathVariable String bookId) {
        String url = BASE_URL + "/book/{bookId}";
        restTemplate.delete(url, bookId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/book/{bookId}/increaseStock/{quantity}")
    public ResponseEntity<Void> increaseBookStock(@PathVariable String bookId, @PathVariable int quantity) {
        String url = BASE_URL + "/book/{bookId}/increaseStock/{quantity}";
        restTemplate.postForEntity(url, null, Void.class, bookId, quantity);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/book/{bookId}/decreaseStock/{quantity}")
    public ResponseEntity<Void> decreaseBookStock(@PathVariable String bookId, @PathVariable int quantity) {
        String url = BASE_URL + "/book/{bookId}/decreaseStock/{quantity}";
        restTemplate.postForEntity(url, null, Void.class, bookId, quantity);
        return ResponseEntity.noContent().build();
    }
}

