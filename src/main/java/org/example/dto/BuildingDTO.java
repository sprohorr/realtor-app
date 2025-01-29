package org.example.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class BuildingDTO {

    private int id;

    @NotEmpty(message = "Address must not be empty! ")
    private String address;

    @NotNull
    @Min(value = 1, message = "Floors must be positive!")
    private Integer floors;

    @NotNull
    @Min(value = 1, message = "Land area must be positive!")
    private Double landArea;

    @NotNull
    @Min(value = 1, message = "Building area must be positive!")
    private Double buildingArea;

    @NotNull
    @Min(value = 1, message = "Quantity apartment must be positive!")
    private Integer quantityApartments;

    @NotNull
    @Min(value = 1900, message = "The year must be less than 1900!")
    @Max(value = 2024, message = "The year must not be greater than 2024!")
    private Integer year;

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

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Double getLandArea() {
        return landArea;
    }

    public void setLandArea(Double landArea) {
        this.landArea = landArea;
    }

    public Double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Integer getQuantityApartments() {
        return quantityApartments;
    }

    public void setQuantityApartments(Integer quantityApartments) {
        this.quantityApartments = quantityApartments;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
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
