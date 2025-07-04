package com.felipesantos.workshopmongo.repository;

import com.felipesantos.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
