package com.catalog.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.catalog.service.model.Book;

/**
 * This interface defines the repository for managing Book entities in a MongoDB database.
 * It extends the `MongoRepository<Book, String>` class, which provides basic CRUD operations
 * for `Book` objects with String as the ID type.
 */
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    /**
     * Finds a list of books where the title contains the given string (case-insensitive).
     * @param title The title string to search for.
     * @return A list of books matching the search criteria.
     */
    List<Book> findByTitleContainingIgnoreCase(String title);

    /**
     * Finds a list of books where the author contains the given string (case-insensitive).
     * @param author The author string to search for.
     * @return A list of books matching the search criteria.
     */
    List<Book> findByAuthorContainingIgnoreCase(String author);

    /**
     * Finds a book by its ISBN number.
     * @param isbn The ISBN number of the book.
     * @return The book matching the ISBN, or null if not found.
     */
    List<Book> findByIsbn(String isbn);
}
