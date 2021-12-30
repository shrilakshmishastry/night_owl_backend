package com.nightowl.apis.repositories;

import com.nightowl.apis.models.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b FROM Book b where b.title = ?1 ")
    Optional<Book> findBookByName(String title);
}
