package com.library.library_book_management.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Book {

    private int bookId;

    @NotBlank(message = "Book name is required")
    private String bookName;

    @NotBlank(message = "Author name is required")
    private String author;

    @Positive(message = "Price must be positive")
    private double price;

    private boolean available;


    // Default Constructor
    public Book() {
    }


    // Parameterized Constructor
    public Book(int bookId, String bookName, String author,
                double price, boolean available) {

        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.available = available;
    }


    // Getter and Setter for bookId
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    // Getter and Setter for bookName
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // Getter and Setter for available
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}