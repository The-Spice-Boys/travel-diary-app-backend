package com.spice_boys.travel_diary_app.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    private String bio;
    private String profilePicUrl;
    private Boolean isPrivate = false;

//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Itinerary> itineraries;
//
//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Favourite> favourites;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

//    public List<Itinerary> getItineraries() {
//        return itineraries;
//    }
//
//    public void setItineraries(List<Itinerary> itineraries) {
//        this.itineraries = itineraries;
//    }
//
//    public List<Favourite> getFavourites() {
//        return favourites;
//    }
//
//    public void setFavourites(List<Favourite> favourites) {
//        this.favourites = favourites;
//    }

    public User() {}

    public User(String username,
                String firstName,
                String lastName,
                String email,
                String password,
                String bio,
                String profilePicUrl,
                Boolean isPrivate) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.profilePicUrl = profilePicUrl;
        this.isPrivate = isPrivate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
