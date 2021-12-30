package com.nightowl.apis.models.dtos;

import com.nightowl.apis.models.entities.Rating;

import java.util.Set;

public class BookGetDto {

        private Long  id;
        private String  title;
        private String authorName;
        private String category;
        private Long isbn;
        private Long pages;
        private String websiteUrl;
        private String cover;
        private String description;


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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    public BookGetDto(Long id,
                      String title,
                      String authorName,
                      String category,
                      Long isbn,
                      Long pages,
                      String websiteUrl,
                      String cover,
                      String description
             ) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.category = category;
        this.isbn = isbn;
        this.pages = pages;
        this.websiteUrl = websiteUrl;
        this.cover = cover;
        this.description = description;

    }
}
