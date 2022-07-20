package com.bookreat.bussi.services;

import com.bookreat.bussi.entities.BookDetails;
import com.bookreat.bussi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookServices
{
    @Autowired
    private BookRepository bookRepository;


    // ReturnAllBook
    public ArrayList<BookDetails> getAllBooks()
    {
        ArrayList<BookDetails> list  = (ArrayList<BookDetails>) this.bookRepository.findAll();
        return list;
    }
    // ReturnBookById
    public BookDetails getBookById(int id)
    {
        return this.bookRepository.findById(id).get();
    }

    public  BookDetails addBook(BookDetails book)
    {
       return this.bookRepository.save(book);
    }

    public String  deleteBookById(int id)
    {

        bookRepository.deleteById(id);
        return "book deleted";
    }


    public String bookUpdateById(BookDetails bookDetails, int id)
    {
        BookDetails bookDetails1 = new BookDetails();
        bookDetails1 = bookRepository.findById(id).get();
        bookDetails1.setName(bookDetails.getName());
        bookDetails1.setName(bookDetails.getName());
        return "updated";
    }

    public List<BookDetails> addAllBooks(List<BookDetails> bookDetails)
    {

        return this.bookRepository.saveAll(bookDetails);
    }
}
