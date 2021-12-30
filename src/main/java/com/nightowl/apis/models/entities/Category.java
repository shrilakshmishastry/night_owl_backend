package com.nightowl.apis.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nightowl.apis.models.entities.Book;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table
public class Category {

    @Id
    @SequenceGenerator(
            name = "Category_sequence",
            sequenceName = "Category_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Category_sequence"
    )
    private Long Id;

    private String description;
    private String name;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "category",cascade = CascadeType.ALL)
    private Set<Book> books;

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Category() {
    }

    public Category(
            String description,
            String name,
            Set<Book> books
            ) {
        this.description = description;
        this.name = name;
        this.books = books;
    }


    public Category(
            Long id,
            String description,
            String name,
            Set<Book> books
    ) {
        Id = id;
        this.description = description;
        this.name = name;
        this.books = books;
    }
}
