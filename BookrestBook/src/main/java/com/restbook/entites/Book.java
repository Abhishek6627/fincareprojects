package com.restbook.entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table (name = "books_durgesh")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private  String  title;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private  Author author;


    public Book()
    {
    }

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}