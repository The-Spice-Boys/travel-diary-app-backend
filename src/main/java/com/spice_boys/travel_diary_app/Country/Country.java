package com.spice_boys.travel_diary_app.Country;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryID;

    private String name;
    private String description;
    private String countryPicUrl;

    public Country(String name, String description, String countryPicUrl) {
        this.name = name;
        this.description = description;
        this.countryPicUrl = countryPicUrl;
    }

    public Country() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountryPicUrl() {
        return countryPicUrl;
    }

    public void setCountryPicUrl(String countryPicUrl) {
        this.countryPicUrl = countryPicUrl;
    }
}
