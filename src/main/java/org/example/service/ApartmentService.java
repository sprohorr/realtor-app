package org.example.service;

import org.example.dto.ApartmentDTO;
import org.example.entity.Apartment;
import org.example.repository.ApartmentRepository;
import org.example.repository.RealtyAgentRepository;
import org.example.util.TransformerDtoApartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

    @Autowired
    protected ApartmentRepository apartmentRepository;

    @Autowired
    protected RealtyAgentRepository realtyAgentRepository;

    @Autowired
    protected TransformerDtoApartment transformerDtoApartment;

    public Apartment findApartmentById(int id) {
        return apartmentRepository.findApartmentById(id);
    }

    public List<Apartment> findAllApartmentsByRealtyAgent(int id) {
        return apartmentRepository.findAllByRealtyAgent_Id(id);
    }

    public Apartment saveApartment(int id, ApartmentDTO apartmentDTO) {
        return apartmentRepository
                .save(transformerDtoApartment.createTransformDtoApartment(id, apartmentDTO));
    }

    public Apartment editApartment(int apartmentId, ApartmentDTO apartmentDTO) {
        return apartmentRepository
                .save(transformerDtoApartment
                        .editTransformDtoApartment(apartmentRepository
                                .findApartmentById(apartmentId), apartmentDTO));
    }
}
