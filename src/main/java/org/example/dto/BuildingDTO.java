package org.example.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class BuildingDTO {

    private int id;

    @NotEmpty(message = "Address must not be empty! ")
    private String address;

    @NotNull(message = "null!")
    private int floors;

    @NotNull(message = "null!")
    private double landArea;

    @NotNull(message = "null!")
    private double buildingArea;

    @NotNull(message = "null!")
    private int quantityApartments;

    @NotNull(message = "null!")
    private int year;

    private boolean parking;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public int getQuantityApartments() {
        return quantityApartments;
    }

    public void setQuantityApartments(int quantityApartments) {
        this.quantityApartments = quantityApartments;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
