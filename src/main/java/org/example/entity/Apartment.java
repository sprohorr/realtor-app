package org.example.entity;

import org.example.util.BooleanConverter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "number_apartment")
    private int number;

    @Column(name = "quantity_rooms")
    private int quantityRooms;

    @Column(name = "apartment_area")
    private double area;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    @Convert(converter = BooleanConverter.class)
    private boolean status;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "realty_agent_id")
    private RealtyAgent realtyAgent;

    public Apartment() {
    }

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
        Apartment apartment = (Apartment) o;
        return id == apartment.id && number == apartment.number && quantityRooms == apartment.quantityRooms && Double.compare(apartment.area, area) == 0 && Double.compare(apartment.price, price) == 0 && status == apartment.status && Objects.equals(description, apartment.description) && Objects.equals(building, apartment.building) && Objects.equals(realtyAgent, apartment.realtyAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, quantityRooms, area, price, status, description, building, realtyAgent);
    }
}
