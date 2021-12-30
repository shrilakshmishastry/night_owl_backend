package com.nightowl.apis.repositories;

import com.nightowl.apis.models.entities.Book;

import com.nightowl.apis.models.entities.Rating;
import com.nightowl.apis.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {

    Optional<Rating> findFirstByBookAndUser(Book book, User user);

    List<Rating> findAllByUser(User user);

    List<Rating> findAllByBook(Book book);
}
