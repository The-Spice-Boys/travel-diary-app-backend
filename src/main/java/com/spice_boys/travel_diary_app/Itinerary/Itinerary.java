package com.spice_boys.travel_diary_app.Itinerary;

import com.spice_boys.travel_diary_app.Activity.Activity;
import com.spice_boys.travel_diary_app.Country.Country;
import com.spice_boys.travel_diary_app.User.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "itineraries")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itineraryId;

    @ManyToOne
    private User user;

    @OneToOne
    private Country country;

    private Boolean isPrivate;

    @OneToMany(mappedBy = "itineraries", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activity> activities;

    public Itinerary(User user, Country country, Boolean isPrivate, List<Activity> activities){
        this.user = user;
        this.country = country;
        this.isPrivate = isPrivate;
        this.activities = activities;
    }

    public Itinerary(){}

    public Long getItineraryId() {
        return itineraryId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
