package com.demo.labmanagement.labmanagement.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.labmanagement.labmanagement.models.Category;
import com.demo.labmanagement.labmanagement.repositories.CategoryRepository;

@RestController
@RequestMapping("/")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/category")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    public Optional<Category> getCategory(@PathVariable("id") Long id) {
        return categoryRepository.findById(id);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryRepository.deleteById(id);
    }

    @PutMapping("/category/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable("id") Long id) {
        if (!category.getId().equals(id)) {
            throw new IllegalArgumentException("Category Id mismatch!");
        }
        return categoryRepository.save(category);
    }
}
