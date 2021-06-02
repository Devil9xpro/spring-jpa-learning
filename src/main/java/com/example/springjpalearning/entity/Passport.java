package com.example.springjpalearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Passport() {
    }

    public Passport(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", number='" + getName() + "'" + "}";
    }

}
