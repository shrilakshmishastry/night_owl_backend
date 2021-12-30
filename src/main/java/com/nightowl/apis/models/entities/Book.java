package com.nightowl.apis.models.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    private  Long id;

    private String title;
    private String authorName;

    public Book() {
    }

    public Book(String title,
                String authorName,
                Long isbn,
                Long pages,
                String websiteUrl,
                String cover,
                String description
               ) {
        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.pages = pages;
        this.websiteUrl = websiteUrl;
        this.cover = cover;
        this.description = description;

    }

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    private Long isbn;
    private Long pages;
    private String websiteUrl;
    private String cover;
    @Lob
    private String description;



    public Book(Long id, String title, String authorName, Category category, Long isbn, Long pages, String websiteUrl, String cover, String description, Set<Rating> ratings) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.category = category;
        this.isbn = isbn;
        this.pages = pages;
        this.websiteUrl = websiteUrl;
        this.cover = cover;
        this.description = description;
        this.ratings = ratings;
    }

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL,orphanRemoval = true)
    Set<Rating> ratings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }
}
