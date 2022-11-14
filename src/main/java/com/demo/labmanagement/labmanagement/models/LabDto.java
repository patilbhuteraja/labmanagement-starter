package com.demo.labmanagement.labmanagement.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("lab")
public class LabDto {

    public LabDto() {
    }

    public LabDto(String name, String description, Long categoryId, Long authorId) {
        this.name = name;
        this.description = description;
        this.categoryid = categoryId;
        this.authorid = authorId;
    }

    @Id
    private Long id;
    private String name;
    private String description;
    private Long authorid;
    private Long categoryid;

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

    public Long getCategoryId() {
        return categoryid;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryid = categoryId;
    }

    public Long getAuthorId() {
        return authorid;
    }

    public void setAuthorId(Long authorId) {
        this.authorid = authorId;
    }
}
