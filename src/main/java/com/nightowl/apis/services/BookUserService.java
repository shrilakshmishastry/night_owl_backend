package com.nightowl.apis.services;

import com.nightowl.apis.models.entities.User;
import com.nightowl.apis.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookUserService {

    private UserRepository bookUserRepository;


    public BookUserService(UserRepository bookUserRepository) {
        this.bookUserRepository = bookUserRepository;
    }


    public User getUser(String name) {

        Optional<User> book_user = bookUserRepository.getUserByName(name);
        System.out.println(name);
        if(book_user.isPresent()){
            return  book_user.get();
        }

        throw new IllegalStateException("User not present");
    }



    public void addUser(User user) {
        Optional<User> book_user = bookUserRepository.getUserByName(user.getName());
        if(book_user.isPresent()){
            throw new IllegalStateException("user already present");
        }
        bookUserRepository.save(user);
    }


}
