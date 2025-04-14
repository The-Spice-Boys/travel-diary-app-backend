package com.spice_boys.travel_diary_app.Activity;

import com.spice_boys.travel_diary_app.Itinerary.Itinerary;
import com.spice_boys.travel_diary_app.Note.Note;
import com.spice_boys.travel_diary_app.Photo.Photo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    @ManyToOne
    private Itinerary itinerary;

    private String title;

    private Boolean completedStatus;

    @OneToMany(mappedBy = "activities", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    @OneToMany(mappedBy = "activities", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos;

    public Activity(Itinerary itinerary, String title, Boolean completedStatus) {
        this.itinerary = itinerary;
        this.title = title;
        this.completedStatus = completedStatus;
        this.notes = new ArrayList<>();
        this.photos = new ArrayList<>();
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompletedStatus() {
        return completedStatus;
    }

    public void setCompletedStatus(Boolean completedStatus) {
        this.completedStatus = completedStatus;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
