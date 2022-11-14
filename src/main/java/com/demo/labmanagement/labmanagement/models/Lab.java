package com.demo.labmanagement.labmanagement.models;

public class Lab {

    public Lab() {
    }

    public Lab(Long id, String name, String description, Author author, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.category = category;
    }

    private Long id;
    private String name;
    private String description;
    private Author author;
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
