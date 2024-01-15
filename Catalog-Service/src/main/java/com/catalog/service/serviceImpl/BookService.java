package com.catalog.service.serviceImpl;

import java.util.List;

import com.catalog.service.model.Book;

public interface BookService {
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    List<Book> searchByIsbn(String isbn);
    Book addBook(Book newBook);
    Book updateBook(String id, Book updatedBook);
    void deleteBook(String id);
	List<Book> getAllBooks();
    
}
