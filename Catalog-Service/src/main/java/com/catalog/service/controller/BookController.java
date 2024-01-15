package com.catalog.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.service.model.Book;
import com.catalog.service.serviceImpl.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
    private BookService bookService;

    @GetMapping("/searchByTitle")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        List<Book> books = bookService.searchByTitle(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/searchByAuthor")
    public ResponseEntity<List<Book>> searchByAuthor(@RequestParam String author) {
        List<Book> books = bookService.searchByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/searchByIsbn")
    public ResponseEntity<List<Book>> searchByIsbn(@RequestParam String isbn) {
        List<Book> book = bookService.searchByIsbn(isbn);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/allBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        Book savedBook = bookService.addBook(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        Book book = bookService.updateBook(id, updatedBook);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}

