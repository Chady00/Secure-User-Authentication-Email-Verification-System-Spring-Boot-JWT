package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // returns a list of all users
    public List<User> allUsers() {
        List<User> users= new ArrayList<>();
        // add each user to the list ( findAll returns an iterable)
        userRepository.findAll().forEach(users::add);
        return users;
    }

}
