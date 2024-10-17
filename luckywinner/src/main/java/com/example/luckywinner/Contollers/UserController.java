package com.example.luckywinner.Contollers;

import com.example.luckywinner.Models.User;
import com.example.luckywinner.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/get")
    public ResponseEntity<User> getWinner() {
        User winner = userService.getRandomUser();
        if (winner == null) {
            return ResponseEntity.notFound().build(); // Return 404 if no users found
        }
        System.out.println(winner.toString());
        return ResponseEntity.ok(winner);
    }

}
