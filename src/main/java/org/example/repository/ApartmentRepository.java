package org.example.repository;

import org.example.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

    List<Apartment> findAllByBuilding_Id(int id);

    List<Apartment> findAllByRealtyAgent_Id(int id);

    Apartment findApartmentById(int id);
}
