package org.example.service;

import org.example.dto.ApartmentDTO;
import org.example.entity.Apartment;
import org.example.repository.ApartmentRepository;
import org.example.repository.BuildingRepository;
import org.example.util.TransformerDtoApartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

    @Autowired
    protected ApartmentRepository apartmentRepository;

    @Autowired
    protected BuildingRepository buildingRepository;

    @Autowired
    protected TransformerDtoApartment transformerDtoApartment;

    //check
    public Page<Apartment> findAll(Pageable pageable) {
        return apartmentRepository.findAll(pageable);
    }

    public List<Apartment> readAll() {
        return apartmentRepository.findAll();
    }

    public Apartment findApartmentById(int id) {
        return apartmentRepository.findById(id).orElse(null);
    }

    public Page<Apartment> findAllApartmentsByRealtyAgent(int id, Pageable pageable) {
        return apartmentRepository.findAllByRealtyAgent_Id(id, pageable);
    }

    public List<Apartment> findAllApartmentByBuilding(int id) {
        return apartmentRepository.findAllByBuilding_Id(id);
    }

    public Apartment saveApartment(int buildingId, ApartmentDTO apartmentDTO) {
        Apartment apartment = new Apartment();
        apartment.setBuilding(buildingRepository.findById(buildingId).get());
        return apartmentRepository
                .save(transformerDtoApartment.populateBeanFromDTO(apartment, apartmentDTO));
    }

    public Apartment editApartment(int apartmentId, ApartmentDTO apartmentDTO) {
        Apartment apartment = apartmentRepository.findById(apartmentId).get();
        apartment.setBuilding(apartmentDTO.getBuilding());
        return apartmentRepository
                .save(transformerDtoApartment
                        .populateBeanFromDTO(apartment, apartmentDTO));
    }

    public Apartment saveApartmentFromExcel(Apartment apartment) {
        Apartment apartmentDB = apartmentRepository
                .findByBuilding_AddressAndAndNumber
                        (apartment.getBuilding().getAddress(), apartment.getNumber());
        apartmentDB.setNumber(apartment.getNumber());
        apartmentDB.setQuantityRooms(apartment.getQuantityRooms());
        apartmentDB.setArea(apartment.getArea());
        apartmentDB.setPrice(apartment.getPrice());
        apartmentDB.setStatus(apartment.isStatus());
        apartmentDB.setDescription(apartment.getDescription());
        apartmentDB.setBuilding(apartment.getBuilding());
        apartmentDB.setRealtyAgent(apartment.getRealtyAgent());
        return apartmentRepository.save(apartmentDB);
    }

    public boolean checkIfApartmentByBuildingIdAndNumber(int buildingId, int number) {
        return apartmentRepository.existsApartmentByBuilding_IdAndNumber(buildingId, number);
    }
}
