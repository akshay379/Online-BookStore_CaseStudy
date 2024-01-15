package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;

import com.user.service.model.Book;

@RestController
@RequestMapping("/users/books")
public class CatalogController {

	private final String BASE_URL = "http://localhost:8082/books";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/searchByTitle")
	public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
		String url = BASE_URL + "/searchByTitle?title={title}";
		ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Book>>() {
				}, title);
		return responseEntity;
	}

	@GetMapping("/searchByAuthor")
	public ResponseEntity<List<Book>> searchByAuthor(@RequestParam String author) {
		String url = BASE_URL + "/searchByAuthor?author={author}";
		ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Book>>() {
				}, author);
		return responseEntity;
	}

	@GetMapping("/searchByIsbn")
	public ResponseEntity<List<Book>> searchByIsbn(@RequestParam String isbn) {
		String url = BASE_URL + "/searchByIsbn?isbn={isbn}";
		ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Book>>() {
				}, isbn);
		return responseEntity;
	}

	@GetMapping("/allBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		String url = BASE_URL + "/allBooks";
		ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Book>>() {
				});
		return responseEntity;
	}

	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
		String url = BASE_URL + "/addBook";
		return restTemplate.postForEntity(url, newBook, Book.class);
	}

	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
		String url = BASE_URL + "/updateBook/{id}";
		restTemplate.put(url, updatedBook, id);
		return ResponseEntity.ok(updatedBook);
	}

	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable String id) {
		String url = BASE_URL + "/deleteBook/{id}";
		restTemplate.delete(url, id);
		return ResponseEntity.noContent().build();
	}

}
