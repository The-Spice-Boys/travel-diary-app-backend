package com.spice_boys.travel_diary_app.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Post user request
    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get user request
    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
