package org.example.repository;

import org.example.entity.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ApartmentRepository extends PagingAndSortingRepository<Apartment, Integer> {

    Page<Apartment> findAll(Pageable pageable);

    List<Apartment> findAll();

    List<Apartment> findAllByBuilding_Id(int id);

    Page<Apartment> findAllByRealtyAgent_Id(int id, Pageable pageable);

    Apartment findByBuilding_AddressAndAndNumber(String address, int number);

    boolean existsApartmentByBuilding_IdAndNumber(int buildingId, int number);

}
