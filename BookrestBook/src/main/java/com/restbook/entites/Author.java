package com.restbook.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
//@Table(name = "author")
public class Author
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private   int authorId;
    //@Column(name = "firstName")
    private  String fName;
    private  String  lName;
    private String   lang;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private  Book book;

    public Author()
    {
    }

    public Author(int authorId, String fName, String lName, String lang) {
        this.authorId = authorId;
        this.fName = fName;
        this.lName = lName;
        this.lang = lang;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
