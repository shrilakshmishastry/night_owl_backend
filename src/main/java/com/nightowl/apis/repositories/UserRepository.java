package com.nightowl.apis.repositories;

import com.nightowl.apis.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(" SELECT u FROM User u WHERE u.name =?1")
    Optional<User> getUserByName(String name);
}
