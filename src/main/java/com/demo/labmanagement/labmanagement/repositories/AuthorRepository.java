package com.demo.labmanagement.labmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.demo.labmanagement.labmanagement.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
