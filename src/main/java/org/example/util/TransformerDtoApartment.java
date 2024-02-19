package org.example.util;

import org.example.dto.ApartmentDTO;
import org.example.entity.Apartment;
import org.springframework.stereotype.Component;

@Component
public class TransformerDtoApartment {

    public Apartment populateBeanFromDTO(Apartment apartment, ApartmentDTO apartmentDTO) {
        apartment.setRealtyAgent(apartmentDTO.getRealtyAgent());
        apartment.setNumber(apartmentDTO.getNumber());
        apartment.setQuantityRooms(apartmentDTO.getQuantityRooms());
        apartment.setArea(apartmentDTO.getArea());
        apartment.setPrice(apartmentDTO.getPrice());
        apartment.setDescription(apartmentDTO.getDescription());
        apartment.setStatus(apartmentDTO.isStatus());
        return apartment;
    }
}
