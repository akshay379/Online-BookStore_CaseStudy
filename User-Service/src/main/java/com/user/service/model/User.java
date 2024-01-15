package com.user.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// Annotation indicating this class is an entity mapped to a table

@Document(collection = "users")
public class User {

	// Primary key for the user entity
	@Id
	private Long id;

	// User's name
	private String name;

	// User's email
	private String email;

	// User's address
	private String address;

	// Getter and setter methods for the 'id' field
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Getter and setter methods for the 'name' field
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Getter and setter methods for the 'email' field
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Getter and setter methods for the 'address' field
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// toString() method overriding to represent object details as a string
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}

	// Parameterized constructor for the User class
	public User(Long id, String name, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	// Default constructor for the User class
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
