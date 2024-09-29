package com.example.books.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * Main Object class
 */
@Entity
@Data
@Table(name = "books")
public class Book {
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Id
    @Column(name = "isbn")
    private int isbn;
    @Column(name = "rating")
    private int Rating;
    @Column(name = "year")
    private int Year;

    public Book(String title, String author, int isbn, int rating, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        Rating = rating;
        Year = year;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }


}
