package org.example.dto;

import org.example.entity.Building;
import org.example.entity.RealtyAgent;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class ApartmentDTO {

    private int id;

    @NotNull(message = "Input number!")
    @Digits(integer = 3, fraction = 0, message = "No more than 3 digits!")
    private int number;

    @NotNull(message = "Input quantity rooms!")
    @Digits(integer = 2, fraction = 0, message = "No more than 1 digit!")
    private int quantityRooms;

    @NotNull(message = "Input area!")
    @Digits(integer = 3, fraction = 1, message = "For example: 123.4")
    private double area;

    @NotNull
    @Digits(integer = 7, fraction = 2, message = "For example: 1234567.89")
    private double price;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQuantityRooms() {
        return quantityRooms;
    }

    public void setQuantityRooms(int quantityRooms) {
        this.quantityRooms = quantityRooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
