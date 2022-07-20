package com.bookreat.bussi.repository;

import com.bookreat.bussi.entities.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends JpaRepository<BookDetails,Integer>
{
    //  public ArrayList<BookDetails> getAllBooks();
}
