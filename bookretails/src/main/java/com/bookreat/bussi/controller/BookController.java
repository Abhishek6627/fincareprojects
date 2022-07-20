package com.bookreat.bussi.controller;

import com.bookreat.bussi.entities.BookDetails;
import com.bookreat.bussi.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import  java.util.List;
import java.awt.*;
import java.awt.print.Book;
import java.util.ArrayList;

@RestController
public class BookController
{
    @Autowired
    private  BookServices bookServices;

    @GetMapping("/allBook")
    public ArrayList<BookDetails> getAllBooks()
    {
     return  this.bookServices.getAllBooks();
    }
    @GetMapping("/bookById/{id}")
    public   BookDetails getBookById(@PathVariable("id")int id)
    {
        return this.bookServices.getBookById(id);

    }
    @PostMapping("/addBook")
    public BookDetails addBook(@RequestBody BookDetails book)
    {
        return bookServices.addBook(book);
    }

    @PostMapping("/addAllBooks")
    public List<BookDetails> addAllBooks(@RequestBody List<BookDetails> bookDetails)
    {
        return bookServices.addAllBooks(bookDetails);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public String deleteBookById(@PathVariable("id") int id)
    {
        return this.bookServices.deleteBookById(id);
    }

    @PutMapping("/bookUpdateById/{id}")
    public String bookUpdateById(@RequestBody BookDetails bookDetails, @PathVariable("id") int id)
    {
        return  bookServices.bookUpdateById(bookDetails, id);
    }
}
