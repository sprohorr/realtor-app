package org.example.dto;

import org.example.entity.Building;
import org.example.entity.RealtyAgent;

import java.util.Objects;

public class ApartmentDTO {

    private int id;

    private int number;

    private int quantityRooms;

    private double area;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentDTO that = (ApartmentDTO) o;
        return id == that.id && number == that.number && quantityRooms == that.quantityRooms && Double.compare(that.area, area) == 0 && Double.compare(that.price, price) == 0 && status == that.status && Objects.equals(description, that.description) && Objects.equals(building, that.building) && Objects.equals(realtyAgent, that.realtyAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, quantityRooms, area, price, status, description, building, realtyAgent);
    }
}
