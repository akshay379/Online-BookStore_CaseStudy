package com.user.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.dao.UserRepository;
import com.user.service.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public User getUserById(Long userId) {
        // Find user by ID or throw an exception if not found
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Update user details
    public User updateUser(Long userId, User updatedUser) {
        // Find the existing user or throw an exception if not found
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update fields with the new values
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setAddress(updatedUser.getAddress());

        return userRepository.save(existingUser);
    }

    // Delete user by ID
    public void deleteUser(Long userId) {
        // Check if user exists, if not, throw an exception
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        // Delete the user by ID
        userRepository.deleteById(userId);
    }
}
