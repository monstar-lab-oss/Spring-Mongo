package com.mongopoc.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongopoc.models.User;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findById(String id);
	List<User> findAll();
	List<User> findByFirstName(String firstName);
	List<User> findByLastName(String lastName);
}