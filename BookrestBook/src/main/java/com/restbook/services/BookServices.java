package com.restbook.services;

import com.restbook.repository.BookRepository;
import com.restbook.entites.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServices
{

    @Autowired
    private BookRepository bookRepository;
//    private static  List<Book> list = new ArrayList<>();
//
//    static
//    {
//        list.add(new Book(1 ,"java","lara"));
//        list.add(new Book(2 ,"python","gfg"));
//        list.add(new Book(3 ,"spring boot","javatpoint"));
//    }

    //getAllBook
    public  List<Book> getAllBook()
    {
      //  List<Book>list =(List<Book>) this.bookRepository.findAll();
        //return list;
        return this.bookRepository.findAll();
    }


    // getsingleBook

    public  Book getSingleBook( int id)
    {
        Book book= null;
       try {
           //book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        book = this.bookRepository.findById(id).get();
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       return  book;
    }
//adding the book
    public Book  addBook(Book b)
    {
        //list.add(b);
        Book result= bookRepository.save(b);
        return result;
    }

    //delete book
    public String deleteBook(int bookId)
    {
//        list=  list.stream().filter(book ->book.getId()!=bookId)
//        .collect(Collectors.toList());
       bookRepository.deleteById(bookId);
        return  "deleted";
    }

    //updateBook
    public void upadateBook(Book book, int bookId)
    {
//      list=  list.stream().map(b->{
//            if (b.getId()==bookId)
//            {
//                b.setTitle(book.getTitle());
//                b.setAuthor(book.getAuthor());
//            }
//            return b;
//        }).collect(Collectors.toList());

            book.setId(bookId);
        bookRepository.save(book);
    }
}