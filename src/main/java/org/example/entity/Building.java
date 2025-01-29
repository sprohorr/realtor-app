package org.example.entity;

import org.example.util.BooleanConverter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "floors")
    private int floors;

    @Column(name = "land_area")
    private double landArea;

    @Column(name = "building_area")
    private double buildingArea;

    @Column(name = "quantity_apartments")
    private int quantityApartments;

    @Column(name = "year")
    private int year;

    @Column(name = "parking")
    @Convert(converter = BooleanConverter.class)
    private boolean parking;

    @Column(name = "description")
    private String description;

    public Building() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return id == building.id && floors == building.floors && Double.compare(building.landArea, landArea) == 0 && Double.compare(building.buildingArea, buildingArea) == 0 && quantityApartments == building.quantityApartments && year == building.year && parking == building.parking && Objects.equals(address, building.address) && Objects.equals(description, building.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, floors, landArea, buildingArea, quantityApartments, year, parking, description);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", floors=" + floors +
                ", landArea=" + landArea +
                ", buildingArea=" + buildingArea +
                ", quantityApartments=" + quantityApartments +
                ", year=" + year +
                ", parking=" + parking +
                ", description='" + description + '\'' +
                '}';
    }
}
