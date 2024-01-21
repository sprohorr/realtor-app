package org.example.util;

import org.example.dto.BuildingDTO;
import org.example.entity.Building;
import org.springframework.stereotype.Component;

@Component
public class TransformerDtoBuilding {

    public Building transformDtoBuilding(BuildingDTO buildingDTO) {
        Building building = new Building();
        building.setAddress(buildingDTO.getAddress());
        building.setFloors(buildingDTO.getFloors());
        building.setLandArea(buildingDTO.getLandArea());
        building.setBuildingArea(buildingDTO.getBuildingArea());
        building.setQuantityApartments(buildingDTO.getQuantityApartments());
        building.setYear(buildingDTO.getYear());
        building.setParking(buildingDTO.isParking());
        building.setDescription(buildingDTO.getDescription());
        return building;
    }

    public Building transformEditDtoBuilding(Building building, BuildingDTO buildingDTO) {
        building.setAddress(buildingDTO.getAddress());
        building.setFloors(buildingDTO.getFloors());
        building.setLandArea(buildingDTO.getLandArea());
        building.setBuildingArea(buildingDTO.getBuildingArea());
        building.setQuantityApartments(buildingDTO.getQuantityApartments());
        building.setYear(buildingDTO.getYear());
        building.setParking(buildingDTO.isParking());
        building.setDescription(buildingDTO.getDescription());
        return building;
    }
}
