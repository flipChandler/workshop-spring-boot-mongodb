package com.felipesantos.workshopmongo.repository;

import com.felipesantos.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
