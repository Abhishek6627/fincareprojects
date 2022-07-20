package com.practice.bookrestbook.services;

import com.practice.bookrestbook.entites.Book;
import com.practice.bookrestbook.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServices {
//    private static List<Book> list = new ArrayList<>();
//
//    static {
//        list.add(new Book(1, "Java dev", "lara"));
//        list.add(new Book(2, "Spring  Boot ", "udemy"));
//        list.add(new Book(3, "python", "gfg"));
//    }
    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllbook()
    {
        return this.bookRepo.findAll();
    }

    public Book getBookById(int id)
    {
//        Book book1 = new Book();
//        for (Book b : list) {
//            if (id == b.getId()) {
//                book1 = b;
//            }
//        }

        Book book1 = this.bookRepo.findById(id).get();

        return book1;
    }

    public Book addBook(Book b)
    {
        //list.add(b);
        Book b1= this.bookRepo.save(b);
        return b1;
    }

    public String deleteBook(int bookId) {
//        for (int i = 0; i<list.size();i++)
//        {
//            if (bookId == list.get(i).getId())
//            {
//                list.remove(list.get(i));
//            }
//        }
       // list = list.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());

        this.bookRepo.deleteById(bookId);
        return  "Deleted Success";

    }


    public String updateBook(Book book, int bookId)
    {
//        list = list.stream().map(b -> {
//                if (b.getId()==bookId)
//                {
//                    b.setName(book.getName());
//                    b.setAuthor(book.getAuthor());
//                }
//               return  b;
//        }).collect(Collectors.toList());


//        for (int i = 0; i < list.size(); i++)
//        {
//            if (bookId == list.get(i).getId()) {
//                list.get(i).setName(book.getName());
//                list.get(i).setAuthor(book.getAuthor());
//            }
//        }
            book.setId(bookId);
            bookRepo.save(book);
        return  "Updated";

    }

}
