package com.example.phonebookapi.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "PHONEBOOK")
public class Database {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private String city;
    private String street;

    private int buildnumber;

    @Length(max = 11)
    private String numbertel;

    private boolean aprove;

    public boolean isAprove() {
        return aprove;
    }

    public void setAprove(boolean aprove) {
        this.aprove = aprove;
    }

    public String getNumbertel() {
        return numbertel;
    }

    public void setNumbertel(String numbertel) {
        this.numbertel = numbertel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuildnumber() {
        return buildnumber;
    }

    public void setBuildnumber(int buildnumber) {
        this.buildnumber = buildnumber;
    }
}
