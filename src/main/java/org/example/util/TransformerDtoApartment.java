package org.example.util;

import org.example.dto.ApartmentDTO;
import org.example.entity.Apartment;
import org.example.repository.RealtyAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransformerDtoApartment {

    @Autowired
    protected RealtyAgentRepository realtyAgentRepository;

    public Apartment createTransformDtoApartment(int id, ApartmentDTO apartmentDTO) {
        Apartment apartment = new Apartment();
        apartment.setRealtyAgent(realtyAgentRepository.findRealtyAgentById(id));
        apartment.setNumber(apartmentDTO.getNumber());
        apartment.setQuantityRooms(apartmentDTO.getQuantityRooms());
        apartment.setArea(apartmentDTO.getArea());
        apartment.setPrice(apartmentDTO.getPrice());
        apartment.setDescription(apartmentDTO.getDescription());
        apartment.setStatus(apartmentDTO.isStatus());
        return apartment;
    }

    public Apartment editTransformDtoApartment(Apartment apartment, ApartmentDTO apartmentDTO) {
        apartment.setNumber(apartmentDTO.getNumber());
        apartment.setQuantityRooms(apartmentDTO.getQuantityRooms());
        apartment.setArea(apartmentDTO.getArea());
        apartment.setPrice(apartmentDTO.getPrice());
        apartment.setDescription(apartmentDTO.getDescription());
        apartment.setStatus(apartmentDTO.isStatus());
        return apartment;
    }
}
