package org.example.service;

import org.example.dto.BuildingDTO;
import org.example.entity.Apartment;
import org.example.entity.Building;
import org.example.repository.ApartmentRepository;
import org.example.repository.BuildingRepository;
import org.example.util.TransformerDtoBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    protected BuildingRepository buildingRepository;

    @Autowired
    protected TransformerDtoBuilding transformerDtoBuilding;

    @Autowired
    protected ApartmentRepository apartmentRepository;

    public List<Apartment> findApartmentsFromBuilding(int id) {
        return apartmentRepository.findAllByBuilding_Id(id);
    }

    public Building saveBuilding(BuildingDTO buildingDTO) {
        Building building = new Building();
        return buildingRepository
                .save(transformerDtoBuilding.populateBeanFromDTO(building, buildingDTO));
    }

    public List<Building> findAllBuilding() {
        return buildingRepository.findAll();
    }

    public Optional<Building> findBuildingById(int id) {
        return Optional.ofNullable(buildingRepository.findById(id).orElse(null));
    }

    public Optional<Building> editBuilding(int id, BuildingDTO buildingDTO) {
        return Optional.of(buildingRepository.save(transformerDtoBuilding
                .populateBeanFromDTO(buildingRepository
                        .findById(id).orElse(null), buildingDTO)));
    }
}
