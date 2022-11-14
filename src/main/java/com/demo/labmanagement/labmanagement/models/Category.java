package com.demo.labmanagement.labmanagement.models;

import org.springframework.data.annotation.Id;

public class Category {

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Id
    private Long id;
    private String name;

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
}
