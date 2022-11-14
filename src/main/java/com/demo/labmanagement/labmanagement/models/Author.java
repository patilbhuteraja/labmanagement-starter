package com.demo.labmanagement.labmanagement.models;

import org.springframework.data.annotation.Id;

public class Author {

    public Author() {
    }

    public Author(String firstName, String lastName) {
        firstname = firstName;
        lastname = lastName;
    }

    @Id
    private Long id;
    private String firstname;
    private String lastname;

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        id = Id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        lastname = lastName;
    }
}
