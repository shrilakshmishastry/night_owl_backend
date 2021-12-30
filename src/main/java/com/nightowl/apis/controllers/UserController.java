package com.nightowl.apis.controllers;

import com.nightowl.apis.models.entities.User;
import com.nightowl.apis.services.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final BookUserService bookUserService;

    @Autowired
    public UserController(BookUserService bookUserService) {
        this.bookUserService = bookUserService;
    }

    @GetMapping("/")
    public User getUser(@RequestBody Map<String,String> getName){
        return bookUserService.getUser(getName.get("name"));
    }

    @PostMapping("/add_user")
    public void addUser(@RequestBody User user){
        bookUserService.addUser(user);
    }

    @DeleteMapping("/")
    public String deleteUser(){
        return "deleted";
    }
}

