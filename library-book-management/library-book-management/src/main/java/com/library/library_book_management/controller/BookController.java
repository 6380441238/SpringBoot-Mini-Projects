package com.library.library_book_management.controller;

import com.library.library_book_management.model.Book;
import com.library.library_book_management.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // Constructor Injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    // 1. Add Book
    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {

        Book addedBook = bookService.addBook(book);

        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }


    // 2. Search Book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId) {

        Book book = bookService.getBookById(bookId);

        if (book != null) {
            return ResponseEntity.ok(book);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Book not found");
    }


    // 3. Update Availability
    @PutMapping("/{bookId}/availability")
    public ResponseEntity<?> updateAvailability(
            @PathVariable int bookId,
            @RequestParam boolean available) {

        Book updatedBook =
                bookService.updateAvailability(bookId, available);

        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Book not found");
    }


    // 4. Delete Book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId) {

        boolean deleted = bookService.deleteBook(bookId);

        if (deleted) {
            return ResponseEntity.ok("Book deleted successfully");
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Book not found");
    }
}