package com.spice_boys.travel_diary_app.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
}
