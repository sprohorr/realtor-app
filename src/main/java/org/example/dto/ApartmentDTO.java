package org.example.dto;

import org.example.entity.Building;
import org.example.entity.RealtyAgent;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ApartmentDTO {

    private int id;

    @NotNull
    @Min(value = 1, message = "Number must be positive!")
    @Digits(integer = 3, fraction = 0, message = "No more than 3 digits!")
    private Integer number;

    @NotNull
    @Min(value = 1, message = "Quantity rooms must be positive!")
    @Digits(integer = 2, fraction = 0, message = "No more than 1 digit!")
    private Integer quantityRooms;

    @NotNull
    @Min(value = 1, message = "Area must be positive!")
    @Digits(integer = 3, fraction = 1, message = "For example: 123.4")
    private Double area;

    @NotNull
    @Min(value = 1, message = "Price must be positive!")
    @Digits(integer = 7, fraction = 2, message = "For example: 1234567.89")
    private Double price;

    private boolean status;

    private String description;


    private Building building;

    private RealtyAgent realtyAgent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getQuantityRooms() {
        return quantityRooms;
    }

    public void setQuantityRooms(Integer quantityRooms) {
        this.quantityRooms = quantityRooms;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public RealtyAgent getRealtyAgent() {
        return realtyAgent;
    }

    public void setRealtyAgent(RealtyAgent realtyAgent) {
        this.realtyAgent = realtyAgent;
    }
}
