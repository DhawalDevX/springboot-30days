package com.example.bookapi.repository;

import com.example.bookapi.model.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer>{
    List<Book> findByTitleContaining(String title);

    // @Query JPQL
    @Query("SELECT b FROM Book b WHERE b.price < :price")
    List<Book> findBooksCheaperThan(
            @Param("price") Double price);
}


