package com.example.demo.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;


@Entity
@Table(name="locations")

public class Location {

    @Id
    @Column(name = "location_id", nullable = false, length = 4)
    private Integer id;

    @Column (name = "city", nullable = false, length = 30)
    private String name_city;

    @Column (name = "state_province", length = 25)
    private String satate_province;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_city() {
        return name_city;
    }

    public void setName_city(String name_city) {
        this.name_city = name_city;
    }

    public String getSatate_province() {
        return satate_province;
    }

    public void setSatate_province(String satate_province) {
        this.satate_province = satate_province;
    }
}
