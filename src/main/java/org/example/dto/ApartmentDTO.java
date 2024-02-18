package org.example.dto;

import org.example.entity.Building;
import org.example.entity.RealtyAgent;

import javax.validation.constraints.NotNull;

public class ApartmentDTO {

    private int id;

    @NotNull(message = "Null!")
    private int number;

    @NotNull(message = "Null!")
    private int quantityRooms;

    @NotNull(message = "Null!")
    private double area;

    @NotNull(message = "Null!")
    private double price;

    private boolean status;

    private String description;

    @NotNull(message = "Null!")
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
