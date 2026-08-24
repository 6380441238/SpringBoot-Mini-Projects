package com.library.library_book_management.service;

import com.library.library_book_management.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    // ArrayList acts as temporary storage instead of a database
    private final List<Book> bookList = new ArrayList<>();


    // 1. Add Book
    public Book addBook(Book book) {

        bookList.add(book);

        return book;
    }


    // 2. Search Book by ID
    public Book getBookById(int bookId) {

        for (Book book : bookList) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }


    // 3. Update Book Availability
    public Book updateAvailability(int bookId, boolean available) {

        Book book = getBookById(bookId);

        if (book != null) {

            book.setAvailable(available);

            return book;
        }

        return null;
    }


    // 4. Delete Book
    public boolean deleteBook(int bookId) {

        Book book = getBookById(bookId);

        if (book != null) {

            bookList.remove(book);

            return true;
        }

        return false;
    }
}