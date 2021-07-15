package com.apispring.demo.controllers;

import com.apispring.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.apispring.demo.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<User>();

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> users() {
        return this.users;
    }

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {
        /*Optional us =  this.users.stream().filter(user -> user.getId() == id).findFirst();*/
        Optional us = this.userRepository.findById(id);
        if(us.isPresent()) {
            return (User) us.get();
        }
        return null;
    }

    @GetMapping("find-by-name/{name}")
    public List<User> userFindName(@PathVariable("name") String name) {
         return this.userRepository.findByNameIgnoreCase(name);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }
}
