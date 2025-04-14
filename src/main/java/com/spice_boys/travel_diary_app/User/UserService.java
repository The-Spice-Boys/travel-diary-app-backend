package com.spice_boys.travel_diary_app.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public Optional<User> updateUserByUsername(User newUser, String username) {
        var userToUpdate = userRepository.findById(username);
        if (userToUpdate.isPresent()) {
            User foundUser = userToUpdate.get();
            foundUser.setFirstName(newUser.getFirstName());
            foundUser.setLastName(newUser.getLastName());
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setEmail(newUser.getEmail());
            foundUser.setBio(newUser.getBio());
            foundUser.setProfilePicUrl(newUser.getProfilePicUrl());
            foundUser.setPrivate(newUser.getPrivate());
            userRepository.save(foundUser);
            return Optional.of(foundUser);
        }
        return Optional.empty();
    }

    public void deleteUserByUsername(String username) {

        userRepository.findById(username)
                .orElseThrow(()-> new NoSuchElementException("User not found"));
        userRepository.deleteById(username);

    }

}
