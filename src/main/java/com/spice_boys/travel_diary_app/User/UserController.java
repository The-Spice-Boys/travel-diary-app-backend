package com.spice_boys.travel_diary_app.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User savedUser = userService.getUserByUsername(username);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    /* EXAMPLES
    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsersByQueryParameter(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        List<User> savedUsers = userService.getUsersByQueries(firstName, lastName);
        return new ResponseEntity<>(savedUsers, HttpStatus.OK);
    }
    */
}
