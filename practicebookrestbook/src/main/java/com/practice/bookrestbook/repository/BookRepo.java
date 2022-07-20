package com.practice.bookrestbook.repository;

import com.practice.bookrestbook.entites.Book;
//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>
{
   // void delete(int bookId);
}
