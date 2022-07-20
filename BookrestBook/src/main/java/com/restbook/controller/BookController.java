package com.restbook.controller;


import com.restbook.entites.Book;
import com.restbook.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController
{
    @Autowired
    private BookServices bookServices;

    //Get AllBook handler
    @GetMapping("/getBook")
    public ResponseEntity<List<Book>> book()//list isliye lagaya hai qnki return book list kr rhe hain
    {
        List<Book> list = bookServices.getAllBook();
        if (list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    //Get BookById handler
    @GetMapping("/getBook/{id}")
    public  ResponseEntity<Book> getBook(@PathVariable("id") int id)
    {
        Book book= bookServices.getSingleBook(id);
        if (book == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

//Create new Book handler
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        Book b = null;
        try {
            b = this.bookServices.addBook(book);
            return  ResponseEntity.of(Optional.of(b));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    // delete book handler

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String >  deleteBook(@PathVariable("bookId") int bookId)
    {
        try {
            this.bookServices.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.of(Optional.of("deleted"));
        }

    }


    //update book handler


    @PutMapping("/book/{bookId}")
    public  ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId)
    {
        try {
            this.bookServices.upadateBook(book, bookId);
            return ResponseEntity.ok().body(book);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
