package org.example.service;

import org.example.dto.ApartmentDTO;
import org.example.entity.Apartment;
import org.example.repository.ApartmentRepository;
import org.example.repository.BuildingRepository;
import org.example.util.TransformerDtoApartment;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Apartment findApartmentById(int id) {
        return apartmentRepository.findById(id).orElse(null);
    }

    public List<Apartment> findAllApartmentsByRealtyAgent(int id) {
        return apartmentRepository.findAllByRealtyAgent_Id(id);
    }

    public Apartment saveApartment(int buildingId, ApartmentDTO apartmentDTO) {
        Apartment apartment = new Apartment();
        apartment.setBuilding(buildingRepository.findById(buildingId).orElse(null));
        return apartmentRepository
                .save(transformerDtoApartment.populateBeanFromDTO(apartment, apartmentDTO));
    }

    public Apartment editApartment(int apartmentId, ApartmentDTO apartmentDTO) {
        return apartmentRepository
                .save(transformerDtoApartment
                        .populateBeanFromDTO(apartmentRepository.findById(apartmentId).orElse(null), apartmentDTO));
    }

    public boolean checkIfApartmentByBuildingIdAndNumber(int buildingId, int number) {
        return apartmentRepository.existsApartmentByBuilding_IdAndNumber(buildingId, number);
    }
}
