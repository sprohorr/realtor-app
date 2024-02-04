package org.example.controllers;

import org.example.dto.BuildingDTO;
import org.example.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuildingController {

    @Autowired
    protected BuildingService buildingService;

    @GetMapping("/buildingapartmentlist")
    public String showApartmentsListFromBuilding(@RequestParam("buildingId") int buildingId, ModelMap modelMap) {
        modelMap.put("apartments", buildingService.findApartmentsFromBuilding(buildingId));
        return "/buildingapartmentlist";
    }

    @GetMapping("/buildingadd")
    public String addBuilding(ModelMap modelMap) {
        modelMap.addAttribute("building", new BuildingDTO());
        return "/buildingadd";
    }

    @PostMapping("/buildingadd")
    public String createBuilding(BuildingDTO buildingDTO) {
        buildingService.saveBuilding(buildingDTO);
        return "redirect:/buildingsuccess";
    }

    @GetMapping("/buildingsuccess")
    public String showSuccess() {
        return "/buildingsuccess";
    }

    @GetMapping("/buildinglist")
    public String showAllBuilding(ModelMap modelMap) {
        modelMap.put("buildings", buildingService.findAllBuilding());
        return "/buildinglist";
    }

    @GetMapping("/buildingedit")
    public String editBuilding(@RequestParam("buildingId") int id, ModelMap modelMap) {
        modelMap.addAttribute("building", new BuildingDTO());
        modelMap.put("building", buildingService.findBuildingById(id));
        return "/buildingedit";
    }

    @PostMapping("/buildingedit")
    public String saveEditBuilding(@RequestParam("buildingId") int id, BuildingDTO buildingDTO) {
        buildingService.editBuilding(id, buildingDTO);
        return "redirect:/buildinglist";
    }
}
