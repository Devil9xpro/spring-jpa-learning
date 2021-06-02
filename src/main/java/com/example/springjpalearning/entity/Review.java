package com.example.springjpalearning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String rating;
    private String description;

    public Review() {
    }

    public Review(String description, String rating) {
        this.rating = rating;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", rating='" + getRating() + "'" + ", description='" + getDescription()
                + "'" + "}";
    }

}
