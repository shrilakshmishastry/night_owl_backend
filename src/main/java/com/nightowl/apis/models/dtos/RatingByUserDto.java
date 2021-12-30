package com.nightowl.apis.models.dtos;

public class RatingByUserDto {

    private String title;
    private String name;
    private Long book_id;
    private Long user_id;
    private int rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public RatingByUserDto(String title, String name, Long book_id, Long user_id, int rating) {
        this.title = title;
        this.name = name;
        this.book_id = book_id;
        this.user_id = user_id;
        this.rating = rating;
    }
}
