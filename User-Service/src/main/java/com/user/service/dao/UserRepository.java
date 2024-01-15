package com.user.service.dao;

import com.user.service.model.User;

/**
 * This interface extends JpaRepository and provides additional methods
 * for interacting with User entities.
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, Long> {
}
