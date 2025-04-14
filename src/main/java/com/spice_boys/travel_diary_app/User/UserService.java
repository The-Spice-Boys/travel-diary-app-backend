package com.spice_boys.travel_diary_app.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findById(username)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public List<User> getUsersByQueries(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return userRepository.findByFirstNameAndLastName(firstName, lastName);
        }
        else if (firstName != null) {
            return userRepository.findByFirstName(firstName);
        }
        else if (lastName != null) {
            return userRepository.findByLastName(lastName);
        }
        else return userRepository.findAll();
    }
}
