package com.spice_boys.travel_diary_app.Favourite;

import com.spice_boys.travel_diary_app.Itinerary.Itinerary;
import com.spice_boys.travel_diary_app.User.User;
import jakarta.persistence.*;

@Entity
@Table(name = "favourites")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favouriteId;

    @OneToOne
    private Itinerary itinerary;
    @ManyToOne
    private User user;

    public Favourite(Itinerary itinerary, User user) {
        this.itinerary = itinerary;
        this.user = user;
    }

    public Long getFavouriteId() {return favouriteId;}

    public Itinerary getItinerary() {return itinerary;}

    public void setItinerary(Itinerary itinerary) {this.itinerary = itinerary;}

    public User getUser() {return user;}

}
