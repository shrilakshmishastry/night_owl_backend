package com.nightowl.apis.repositories;

import com.nightowl.apis.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository
extends JpaRepository<Category,Long> {

    @Query("SELECT c FROM Category c where c.name = ?1 ")
    Optional<Category> findCategoryByName(String name);
}
