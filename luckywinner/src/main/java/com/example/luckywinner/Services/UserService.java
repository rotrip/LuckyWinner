package com.example.luckywinner.Services;

import com.example.luckywinner.Models.User;
import com.example.luckywinner.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getRandomUser() {
        List<User> users = userRepository.findAll();

        // Log or print all users
        if (users.isEmpty()) {
            System.out.println("No users found in the database.");
            return null; // or throw an exception or return a default user
        }

        System.out.println("Users found:");
        for (User user : users) {
            System.out.println(user.toString()); // Assuming User has a meaningful toString() method
        }

        System.out.println("Selecting a random user...");
        return users.get(new Random().nextInt(users.size()));
    }

}
