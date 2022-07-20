package com.practice.bookrestbook.controller;

import com.practice.bookrestbook.entites.Book;
import com.practice.bookrestbook.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookServices bookServices;

    @GetMapping("/book")
    public List<Book> book() {

        return this.bookServices.getAllbook();
    }

    @GetMapping("/bookbyid/{id}")
    public Book get(@PathVariable("id") int id)
    {
        return bookServices.getBookById(id);
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return  this.bookServices.addBook(book);
    }

    @DeleteMapping("/book/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId) {
        this.bookServices.deleteBook(bookId);
        return "Deleted Successful";
    }


    @PutMapping("/book/{bookId}")
    public String  updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
       return this.bookServices.updateBook(book, bookId);
    }
}
