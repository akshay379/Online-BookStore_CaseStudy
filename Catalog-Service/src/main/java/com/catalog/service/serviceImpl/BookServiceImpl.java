package com.catalog.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.catalog.service.model.Book;
import com.catalog.service.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> searchByTitle(String title) {
        try {
            return bookRepository.findByTitleContainingIgnoreCase(title);
        } catch (Exception e) {
            // Handle exceptions (e.g., log, throw custom exception)
            // Log the exception or throw a custom exception and handle it accordingly
            throw new RuntimeException("Error occurred while searching books by title: " + e.getMessage());
        }
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        try {
            return bookRepository.findByAuthorContainingIgnoreCase(author);
        } catch (Exception e) {
            // Handle exceptions (e.g., log, throw custom exception)
            // Log the exception or throw a custom exception and handle it accordingly
            throw new RuntimeException("Error occurred while searching books by author: " + e.getMessage());
        }
    }

    @Override
    public List<Book> searchByIsbn(String isbn) {
        try {
            return bookRepository.findByIsbn(isbn);
        } catch (Exception e) {
            // Handle exceptions (e.g., log, throw custom exception)
            // Log the exception or throw a custom exception and handle it accordingly
            throw new RuntimeException("Error occurred while searching books by ISBN: " + e.getMessage());
        }
    }

    @Override
    public Book addBook(Book newBook) {
        try {
            return bookRepository.save(newBook);
        } catch (Exception e) {
            // Handle exceptions (e.g., log, throw custom exception)
            // Log the exception or throw a custom exception and handle it accordingly
            throw new RuntimeException("Error occurred while adding a book: " + e.getMessage());
        }
    }

    @Override
    public Book updateBook(String id, Book updatedBook) {
        try {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if (optionalBook.isPresent()) {
                Book existingBook = optionalBook.get();
                existingBook.setTitle(updatedBook.getTitle());
                existingBook.setAuthor(updatedBook.getAuthor());
                existingBook.setIsbn(updatedBook.getIsbn());
                existingBook.setPrice(updatedBook.getPrice());
                existingBook.setAvailability(updatedBook.getAvailability());
                return bookRepository.save(existingBook);
            } else {
                throw new RuntimeException("Book not found with id: " + id);
            }
        } catch (Exception e) {
            // Handle exceptions (e.g., log, throw custom exception)
            // Log the exception or throw a custom exception and handle it accordingly
            throw new RuntimeException("Error occurred while updating a book: " + e.getMessage());
        }
    }

    @Override
    public void deleteBook(String id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            // Handle exceptions (e.g., log, throw custom exception)
            // Log the exception or throw a custom exception and handle it accordingly
            throw new RuntimeException("Error occurred while deleting a book: " + e.getMessage());
        }
    }
    
    public List<Book> getAllBooks() {
        // Logic to fetch all books from the data store
        return bookRepository.findAll(); // Assuming you're using JPA repositories
    }
}
