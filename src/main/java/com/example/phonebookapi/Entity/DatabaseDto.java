package com.example.phonebookapi.Entity;

public class DatabaseDto {
    private Long id;

    private String name;

    private String surname;

    private String city;
    private String street;

    private int buildnumber;

    private int numbertel;

    public DatabaseDto(Long id, String name, String surname, String city, String street, int buildnumber, int numbertel) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;
        this.buildnumber = buildnumber;
        this.numbertel = numbertel;
    }

    public int getNumbertel() {
        return numbertel;
    }

    public void setNumbertel(int numbertel) {
        this.numbertel = numbertel;
    }

    public DatabaseDto() {

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
