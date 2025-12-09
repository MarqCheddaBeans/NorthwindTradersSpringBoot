package com.pluralsight.SakilaSpring.models;

public class Film {

    private int fieldID;
    private String title;
    private double rentalRate;

    //empty constructor
    public Film(){
    }

    //constructor that allows us to set properties of the object
    public Film(int fieldID, String title, double rentalRate) {
        this.fieldID = fieldID;
        this.title = title;
        this.rentalRate = rentalRate;
    }

    public int getFilmID() {
        return fieldID;
    }

    public String getTitle() {
        return title;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setFilmID(int fieldID) {
        this.fieldID = fieldID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "fieldID=" + fieldID +
                ", title='" + title + '\'' +
                ", rentalRate=" + rentalRate +
                '}';
    }
}
