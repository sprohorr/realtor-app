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

@Service
public class BuildingService {

    @Autowired
    protected BuildingRepository buildingRepository;

    @Autowired
    protected TransformerDtoBuilding transformerDtoBuilding;

    @Autowired
    protected ApartmentRepository apartmentRepository;

    public List<Apartment> showApartments(int id) {
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

    public Building findBuildingById(int id) {
        return buildingRepository.findById(id);
    }

    public Building editBuilding(int id, BuildingDTO buildingDTO) {
        return buildingRepository.save(transformerDtoBuilding
                .populateBeanFromDTO(buildingRepository
                        .findById(id), buildingDTO));
    }
}
